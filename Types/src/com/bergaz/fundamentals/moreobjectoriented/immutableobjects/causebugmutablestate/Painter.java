package com.bergaz.fundamentals.moreobjectoriented.immutableobjects.causebugmutablestate;

import java.time.Duration;

/**
 * This interface represents entity objects
 * Entity objects are reconstructable with an id
 * Generally we store them in a db
 * They represent a real entity
 */
public interface Painter {
    int getId();
    boolean isAvailable();
    Duration estimateTimeToPaint();
    String getName();
    double estimateSqMeters();
}
