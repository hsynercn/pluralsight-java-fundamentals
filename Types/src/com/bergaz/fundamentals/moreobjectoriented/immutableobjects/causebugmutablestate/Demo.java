package com.bergaz.fundamentals.moreobjectoriented.immutableobjects.causebugmutablestate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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

        int sum1 = 2 + 3;

        Money usd2 = new Money(new BigDecimal(2), usd);
        Money usd3 = new Money(new BigDecimal(3), usd);

        System.out.println(sum1 + (sum1 == 5 ? "==" : "!=") + 5);

        Money sum2 = usd2.add(usd3);
        Money usd5 = new Money(new BigDecimal(5), usd);
        System.out.println(sum2 + (sum2 == usd5 ? "==" : "!=") + usd5);

        System.out.println(sum1 + " is " + (Integer.valueOf(sum1).equals(5) ? "" : "not ") + "equal to " + 5);
        System.out.println(sum2 + " is " + (sum2.equals(usd5) ? "" : "not ") + usd5);

        Currency eur = new Currency("EUR");
        Money eur2 = new Money(new BigDecimal(2), eur);
        Euro coin = new Euro(new BigDecimal(2), eur, "de");

        System.out.println();
        System.out.println(eur2 + " is " + (eur2.equals(coin) ? "" : "not ") + "equal to " + coin);
        System.out.println(coin + " is " + (coin.equals(eur2) ? "" : "not ") + "equal to " + eur2);

        System.out.println();
        Map<Integer, String> amountToName = new HashMap<>();
        amountToName.put(42, "Meaning of life");
        Integer key = 42;
        System.out.println(key + " -> " + amountToName.getOrDefault(key, "nothing, really..."));

        Map<Money, String> costToName = new HashMap<>();
        costToName.put(new Money(new BigDecimal(42), new Currency("USD")), "Cost of life");
        Money cost = new Money(new BigDecimal(42), new Currency("USD"));
        System.out.println(cost + " -> " + costToName.getOrDefault(cost, "nothing, really..."));
    }
}
