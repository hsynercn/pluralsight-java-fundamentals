package com.bergaz.fundamentals.masteringobjectoriented.untanglingobjects;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompositePainter implements Painter{
    private List<Painter> painters;

    public CompositePainter(List<Painter> painters) {
        this.painters = painters;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public Duration estimateTimeToPaint(double sqMeters) {
        return null;
    }

    @Override
    public Money estimateCompensation(double sqMeters) {
        return null;
    }

    @Override
    public String getName() {
        return (String) this.getPainterNames()
                .collect(Collectors.joining(", ", "{", "}"));
    }

    private Stream<String> getPainterNames() {
        return Painter.stream(this.painters).map(Painter::getName);
    }
}
