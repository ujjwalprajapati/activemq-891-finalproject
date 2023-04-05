/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.util;

import static org.junit.Assert.assertEquals;
import org.apache.activemq.util.IdGenerator;
import org.junit.Test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IdGeneratorTest891{
    private IdGenerator idGenerator;

    @Before
    public void setUp() {
        idGenerator = new IdGenerator();
    }

    @Test
    public void testGenerateId() {
        String id1 = idGenerator.generateId();
        String id2 = idGenerator.generateId();

        assertNotNull("Generated ID should not be null", id1);
        assertNotNull("Generated ID should not be null", id2);
        assertNotEquals("Generated IDs should be unique", id1, id2);
    }
}
