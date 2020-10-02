package com.bergaz.fundamentals.iteration_one.generics.conceptintro.circularbuffer;

public class ObjectCircularBuffer {
    private Object[] buffer;
    private int readCursor = 0;
    private int writeCursor = 0;

    public ObjectCircularBuffer(int size) {
        buffer = new Object[size];
    }

    /**
     * Try to write something to the buffer
     * @param value
     * @return
     */
    public boolean offer(Object value) {
        if (buffer[writeCursor] != null) {
            return false;
        }

        buffer[writeCursor] = value;
        writeCursor = next(writeCursor);

        return true;
    }

    /**
     * Try to read something from the buffer
     * @return
     */
    public Object poll() {
        Object value = buffer[readCursor];
        if (value != null) {
            buffer[readCursor] = null;
            readCursor = next(readCursor);
        }
        return value;
    }

    private int next(int index) {
        return (index + 1) % buffer.length;
    }
}