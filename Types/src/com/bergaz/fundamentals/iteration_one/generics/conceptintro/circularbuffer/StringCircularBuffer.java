package com.bergaz.fundamentals.iteration_one.generics.conceptintro.circularbuffer;

/**
 * We can chose to implement a strong type circular buffer class. We can't apply the same solution for other types.
 */
public class StringCircularBuffer {
    private String[] buffer;
    private int readCursor = 0;
    private int writeCursor = 0;

    public StringCircularBuffer(int size) {
        buffer = new String[size];
    }

    /**
     * Try to write something to the buffer
     * @param value
     * @return
     */
    public boolean offer(String value) {
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
    public String poll() {
        String  value = buffer[readCursor];
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
