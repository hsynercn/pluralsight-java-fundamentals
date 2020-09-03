package com.bergaz.fundamentals.moreobjectoriented.specialcaseobject;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Demo {

    public void claimWarranty(Article article) {
        LocalDate today = LocalDate.now();

        if (article.getMoneyBackGuarantee().isValidOd(today)) {
            System.out.println("Offer money back.");
        }

        if (article.getExpressWarranty().isValidOd(today)) {
            System.out.println("Offer repair.");
        }

        System.out.println("--------");

    }

    public void run() {
        LocalDate sellingDate = LocalDate.now().minus(40, ChronoUnit.DAYS);
        Warranty moneyBack1 = new TimeLimitedWarranty(sellingDate, Duration.ofDays(60));
        Warranty warranty1 = new TimeLimitedWarranty(sellingDate, Duration.ofDays(365));

        Article item1 = new Article(moneyBack1, warranty1);

        claimWarranty(item1);

        Article article2 = new Article(null, null);
        this.claimWarranty(item1);
    }
}
