package com.bergaz.fundamentals.moreobjectoriented.immutableobjects.causebugmutablestate;

import java.math.BigDecimal;

public class Demo {
    private boolean isHappyHour;

    /**
     * We changed the method implementation, added happy hour
     * @param cost
     */
    private Money reserve(Money cost) {
        Money finalCost = this.isHappyHour ? cost.scale(0.5) : cost;
        System.out.println("Reserving an item costing " + finalCost);
        return finalCost;
    }

    private void buy(Money wallet, Money cost) {
        boolean enoughMoney = wallet.compareTo(cost) >= 0;
        Money finalCost = this.reserve(cost);
        boolean finalEnough = wallet.compareTo(finalCost) >= 0;

        if (finalEnough && !enoughMoney) {
            System.out.println("Only this time, you will pay " + finalCost + " with your " + wallet);
        }else if (finalEnough) {
            System.out.println("You will pay " + cost + " with your " + wallet);
        } else {
            System.out.println("You cannot pay " + cost + " with your " + wallet);
        }
    }

    public void runDiscoveringBug() {
        Currency usd = new Currency("USD");
        Money usd12 = new Money(new BigDecimal(12), usd);
        Money usd10 = new Money(new BigDecimal(10), usd);
        Money usd7 = new Money(new BigDecimal(7), usd);

        System.out.println("12 from 10");
        this.buy(usd12, usd10);
        this.isHappyHour = true;
        System.out.println("7 from 10");
        this.buy(usd7, usd10);
    }

    public void runInventingValueObject() {
        Currency usd = new Currency("USD");
        Money usd12 = new Money(new BigDecimal(12), usd);
        Money usd10 = new Money(new BigDecimal(10), usd);
        Money usd7 = new Money(new BigDecimal(7), usd);

        System.out.println("12 from 10");
        this.buy(usd12, usd10);
        this.isHappyHour = true;
        System.out.println("7 from 10");
        this.buy(usd7, usd10);
    }
}
