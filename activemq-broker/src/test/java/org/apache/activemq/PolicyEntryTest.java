package org.apache.activemq;

import org.apache.activemq.broker.region.policy.PolicyEntry;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolicyEntryTest {
    private PolicyEntry policyEntry;

    @Before
    public void setUp() {
        policyEntry = new PolicyEntry();
    }

    @Test
    public void testSetAndGetQueuePrefetch() {
        int newPrefetch = 500;

        // Test setting and getting a new queue prefetch value
        policyEntry.setQueuePrefetch(newPrefetch);
        assertEquals("Queue prefetch should be equal", newPrefetch, policyEntry.getQueuePrefetch());

        // Test setting and getting a negative queue prefetch value
        policyEntry.setQueuePrefetch(-1);
        assertEquals("Queue prefetch should not be set to a negative value", -1, policyEntry.getQueuePrefetch());
    }
}
