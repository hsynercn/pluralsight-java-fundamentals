package com.bergaz.fundamentals.masteringobjectoriented.untanglingobjects;

import com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Money;
import com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.PainterStream;
import com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Velocity;

import java.time.Duration;
import java.util.List;

public interface Painter {
    boolean isAvailable();
    Duration estimateTimeToPaint(double sqMeters);
    Money estimateCompensation(double sqMeters);
    String getName();

    default Velocity estimateVelocity(double sqMeters) {
        return new Velocity(sqMeters, this.estimateTimeToPaint(sqMeters));
    }

    static PainterStream stream(List<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> painters) {
        return new PainterStream(painters.stream());
    }
}
