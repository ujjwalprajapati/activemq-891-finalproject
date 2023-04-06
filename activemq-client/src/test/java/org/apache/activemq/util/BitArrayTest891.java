package org.apache.activemq.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.apache.activemq.util.BitArray;

public class BitArrayTest891{
    private BitArray bitArray;

    @Before
    public void setUp() {
        bitArray = new BitArray();
    }

    @Test
    public void testSet() {
        // Test initial state
        assertFalse("Bit should be initially false", bitArray.get(0));
        assertFalse("Bit should be initially false", bitArray.get(1));
        assertFalse("Bit should be initially false", bitArray.get(63));

        // Set bits and test their state
        assertTrue("Setting bit should return previous state (false)", !bitArray.set(0, true));
        assertTrue("Setting bit should return previous state (false)", !bitArray.set(1, true));
        assertTrue("Setting bit should return previous state (false)", !bitArray.set(63, true));

        assertTrue("Bit should be true", bitArray.get(0));
        assertTrue("Bit should be true", bitArray.get(1));
        assertTrue("Bit should be true", bitArray.get(63));

        // Unset bits and test their state
        assertTrue("Setting bit should return previous state (true)", bitArray.set(0, false));
        assertTrue("Setting bit should return previous state (true)", bitArray.set(1, false));
        assertTrue("Setting bit should return previous state (true)", bitArray.set(63, false));

        assertFalse("Bit should be false", bitArray.get(0));
        assertFalse("Bit should be false", bitArray.get(1));
        assertFalse("Bit should be false", bitArray.get(63));
    }
}