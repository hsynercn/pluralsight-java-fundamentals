package com.bergaz.fundamentals.generics.circularbuffer;

public class CircularBuffer<T> {
    private T[] buffer;
    private int readCursor = 0;
    private int writeCursor = 0;

    public CircularBuffer(int size) {
        buffer = (T[]) new Object[size];
    }

    /**
     * Try to write something to the buffer
     * @param value
     * @return
     */
    public boolean offer(T value) {
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
    public T poll() {
        T value = buffer[readCursor];
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
