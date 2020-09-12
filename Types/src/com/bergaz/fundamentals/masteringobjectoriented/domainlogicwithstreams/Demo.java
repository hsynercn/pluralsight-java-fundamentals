package com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Demo {
    private static Painter findCheapest1(double sqMeters, List<Painter> painters) {
        Money lowestCost = Money.ZERO;
        Painter winner = null;
        for (Painter painter : painters) {
            if (painter.isAvailable()) {
                Money cost = painter.estimateCompensation(sqMeters);
                if (winner == null || cost.compareTo(lowestCost) <= 0) {
                    winner = painter;
                    lowestCost = cost;
                }
            }
        }
        return winner;
    }

    private static Painter findCheapest2(double sqMeters, List<Painter> painters) {
        return painters.stream()
                .filter(Painter::isAvailable)
                .min(Comparator.comparing(painter -> painter.estimateCompensation(sqMeters))).get();
    }

    private static Optional<Painter> findCheapestNiceLookingOne(double sqMeters, List<Painter> painters) {
        return Painter.stream(painters).available().cheapest(sqMeters);
    }

    private static Optional<Painter> findCheapest2Optional(double sqMeters, List<Painter> painters) {
        return painters.stream()
                .filter(Painter::isAvailable)
                .min(Comparator.comparing(painter -> painter.estimateCompensation(sqMeters)));
    }

    /**
     * A selection aggregation
     * @param sqMeters
     * @param painters
     * @return
     */
    private static Painter findCheapest3(double sqMeters, List<Painter> painters) {
        return painters.stream()
                .filter(Painter::isAvailable)
                .reduce((acc, current) -> acc.estimateCompensation(sqMeters)
                .compareTo(current.estimateCompensation(sqMeters)) <= 0 ? acc : current).get();
    }

    private static Money getTotalCost(double sqMeters, List<Painter> painters) {
        return painters.stream()
                .filter(Painter::isAvailable)
                .reduce(Money.ZERO, (acc, painter) -> painter.estimateCompensation(sqMeters).add(acc),
                        Money::add);
    }

    private static Money getTotalCost1(double sqMeters, List<Painter> painters) {
        return painters.stream()
                .filter(Painter::isAvailable)
                .map(painter -> painter.estimateCompensation(sqMeters))
                .reduce(Money::add)
                .orElse(Money.ZERO);
    }

    public void run() {
        
    }
}
