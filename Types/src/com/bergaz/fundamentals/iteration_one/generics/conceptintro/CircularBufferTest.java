package com.bergaz.fundamentals.iteration_one.generics.conceptintro;

import com.bergaz.fundamentals.iteration_one.generics.conceptintro.circularbuffer.ObjectCircularBuffer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularBufferTest {

    private ObjectCircularBuffer buffer = new ObjectCircularBuffer(2);

    @Test
    public void shouldOfferPollableElement() {
        assertTrue(buffer.offer(1));
        assertEquals(1, buffer.poll());
        assertNull(buffer.poll());
    }

    @Test
    public void shouldNotOfferWhenBufferIsFull() {
        assertTrue(buffer.offer(1));
        assertTrue(buffer.offer(2));
        assertFalse(buffer.offer(3));
    }

    @Test
    public void shouldNotPollWhenBufferIsEmpty() {
        assertNull(buffer.poll());
    }

}