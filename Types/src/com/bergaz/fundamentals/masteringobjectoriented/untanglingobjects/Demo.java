package com.bergaz.fundamentals.masteringobjectoriented.untanglingobjects;

import com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Velocity;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Demo {
    private MoneyRate perHour(double amount) {
        return MoneyRate.hourly(new Money(new BigDecimal(amount)));
    }

    private List<Painter> createPainters() {
        return Arrays.asList(
                new ProportionalPainter("Joe", 2.12, this.perHour(44)),
                new ProportionalPainter("Jill", 4.16, this.perHour(60)),
                new ProportionalPainter("Jack", 1.19, this.perHour(16))
        );
    }

    private static com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter findCheapest1(double sqMeters, List<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> painters) {
        com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Money lowestCost = com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Money.ZERO;
        com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter winner = null;
        for (com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter painter : painters) {
            if (painter.isAvailable()) {
                com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Money cost = painter.estimateCompensation(sqMeters);
                if (winner == null || cost.compareTo(lowestCost) <= 0) {
                    winner = painter;
                    lowestCost = cost;
                }
            }
        }
        return winner;
    }

    private static com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter findCheapest2(double sqMeters, List<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> painters) {
        return painters.stream()
                .filter(com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter::isAvailable)
                .min(Comparator.comparing(painter -> painter.estimateCompensation(sqMeters))).get();
    }

    private static Optional<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> findCheapestNiceLookingOne(double sqMeters, List<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> painters) {
        return com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter.stream(painters).available().cheapest(sqMeters);
    }

    private static Optional<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> findCheapest2Optional(double sqMeters, List<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> painters) {
        return painters.stream()
                .filter(com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter::isAvailable)
                .min(Comparator.comparing(painter -> painter.estimateCompensation(sqMeters)));
    }

    /**
     * A selection aggregation
     * @param sqMeters
     * @param painters
     * @return
     */
    private static com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter findCheapest3(double sqMeters, List<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> painters) {
        return painters.stream()
                .filter(com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter::isAvailable)
                .reduce((acc, current) -> acc.estimateCompensation(sqMeters)
                        .compareTo(current.estimateCompensation(sqMeters)) <= 0 ? acc : current).get();
    }

    private static com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Money getTotalCost(double sqMeters, List<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> painters) {
        return painters.stream()
                .filter(com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter::isAvailable)
                .reduce(com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Money.ZERO, (acc, painter) -> painter.estimateCompensation(sqMeters).add(acc),
                        com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Money::add);
    }

    private static com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Money getTotalCost1(double sqMeters, List<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> painters) {
        return painters.stream()
                .filter(com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter::isAvailable)
                .map(painter -> painter.estimateCompensation(sqMeters))
                .reduce(com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Money::add)
                .orElse(com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Money.ZERO);
    }

    public void workTogether(double sqMeters, List<com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter> painters) {
        com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Velocity groupVelocity =
                com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter.stream(painters).available()
                        .map(painter -> painter.estimateVelocity(sqMeters))
                        .reduce(com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Velocity::add)
                        .orElse(Velocity.ZERO);

        com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Painter.stream(painters).available()
                .forEach(painter -> {
                    double partialSqMeters = sqMeters * painter.estimateVelocity(sqMeters).divideBy(groupVelocity);
                    com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams.Money partialCost = painter.estimateCompensation(partialSqMeters);
                    Duration partialTime = painter.estimateTimeToPaint(partialSqMeters);
                });
    }

    public void run() {

    }
}