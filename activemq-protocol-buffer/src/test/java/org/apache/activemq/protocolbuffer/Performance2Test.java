/**
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.protocolbuffer;

import java.io.*;

/**
 * @version $Revision: 1.1 $
 */
public class Performance2Test extends TestSupport {

    protected String fileName = "target/messages2.openwire";
    protected OpenWire.Destination destination = OpenWire.Destination.newBuilder().setName("FOO.BAR").setType(OpenWire.Destination.DestinationType.QUEUE).build();

    public void testPerformance() throws Exception {
        OutputStream out = new BufferedOutputStream(new FileOutputStream(fileName));

        StopWatch watch = createStopWatch("writer");
        for (int i = 0; i < messageCount; i++) {
            watch.start();
            OpenWire.Message.Builder builder = OpenWire.Message.newBuilder()
                    .setDestination(destination)
                    .setPersistent(true)
                    .setType("type:" + i)
                    .setCorrelationId("ABCD");

            if (useProducerId) {
                builder = builder.setProducerId(1234)
                        .setProducerCounter(i);
            }

            OpenWire.Message message = builder.build();

            if (verbose) {
                System.out.println("Writing message: " + i + " = " + message);
            }
            byte[] bytes = message.toByteArray();
            int size = bytes.length;
            out.write(size);
            //System.out.println("writing bytes: " + size);
            out.write(bytes);
            watch.stop();
        }
        out.flush();
        out.close();

        // now lets try read them!
        StopWatch watch2 = createStopWatch("reader");
        InputStream in = new BufferedInputStream(new FileInputStream(fileName));
        for (int i = 0; i < messageCount; i++) {
            watch2.start();

            int size = in.read();
            byte[] data = new byte[size];
            in.read(data);
            OpenWire.Message message = OpenWire.Message.parseFrom(data);
            if (verbose) {
                System.out.println("Reading message: " + i + " = " + message);
            }
            watch2.stop();
        }
        in.close();
    }

    private StopWatch createStopWatch(String name) {
        StopWatch answer = new StopWatch(name);
        answer.setLogFrequency(messageCount / 10);
        return answer;
    }

}