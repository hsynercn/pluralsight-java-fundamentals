package com.bergaz.fundamentals.masteringobjectoriented.untanglingobjects;

import com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.ForwardingStream;
import com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class PainterStream implements ForwardingStream<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> {
    private Stream<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> stream;

    public PainterStream(Stream<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> stream) {
        this.stream = stream;
    }

    @Override
    public Stream<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> getStream() {
        return stream;
    }

    public com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.PainterStream available() {
        return new com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.PainterStream(this.getStream().filter(com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter::isAvailable));
    }

    public Optional<Painter> cheapest(double sqMeters) {
        return this.getStream().min(Comparator.comparing(painter -> painter.estimateCompensation(sqMeters)));
    }
}
