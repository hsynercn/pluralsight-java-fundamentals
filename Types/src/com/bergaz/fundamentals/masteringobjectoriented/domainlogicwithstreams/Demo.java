package com.bergaz.fundamentals.masteringobjectoriented.domainlogicwithstreams;

import java.util.List;

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

    public void run() {
        
    }
}
