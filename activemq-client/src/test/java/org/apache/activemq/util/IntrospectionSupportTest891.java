package org.apache.activemq.util;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class IntrospectionSupportTest891{

    private TestBean testBean;
    private Map<String, Object> properties;

    @Before
    public void setUp() {
        testBean = new TestBean();
        properties = new HashMap<>();
        properties.put("field1", "testValue");
        properties.put("field2", "42");
    }

    @Test
    public void testSetProperties() {
        boolean didSet = IntrospectionSupport.setProperties(testBean, properties);

        assertEquals("setProperty should return true", true, didSet);
        assertEquals("field1 should have the correct value", "testValue", testBean.getField1());
        assertEquals("field2 should have the correct value", 42, testBean.getField2());
    }

    public static class TestBean {
        private String field1;
        private int field2;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public int getField2() {
            return field2;
        }

        public void setField2(int field2) {
            this.field2 = field2;
        }
    }
}
