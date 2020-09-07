package com.bergaz.fundamentals.moreobjectoriented.specialcaseobject;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Demo {

    public void offerMoneyBack() {
        System.out.println("Offer money back.");
    }

    public void offerRepair() {
        System.out.println("Offer repair.");
    }

    public void claimWarranty(Article article) {
        LocalDate today = LocalDate.now();

        article.getMoneyBackGuarantee().on(today).claim(this::offerMoneyBack);

        article.getExpressWarranty().on(today).claim(this::offerRepair);

        System.out.println("--------");

    }

    public void run() {
        LocalDate sellingDate = LocalDate.now().minus(40, ChronoUnit.DAYS);
        Warranty moneyBack1 = new TimeLimitedWarranty(sellingDate, Duration.ofDays(60));
        Warranty warranty1 = new TimeLimitedWarranty(sellingDate, Duration.ofDays(365));

        Article item1 = new Article(moneyBack1, warranty1);

        claimWarranty(item1);

        /**
         * We get a exception from below line
         * We can replace nulls with proper objects
         */
        //Article article2 = new Article(null, null);
        //this.claimWarranty(item1);

        Article article2 = new Article(Warranty.VOID, Warranty.VOID);
        this.claimWarranty(item1);
    }
}
