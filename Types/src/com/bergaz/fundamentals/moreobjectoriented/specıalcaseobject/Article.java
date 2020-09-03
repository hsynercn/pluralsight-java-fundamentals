package com.bergaz.fundamentals.moreobjectoriented.specıalcaseobject;

public class Article {
    private Warranty moneyBackGuarantee;
    private Warranty expressWarranty;

    /**
     * Constructor should never receive a null value
     * @param moneyBackGuarantee
     * @param expressWarranty
     */
    public Article(Warranty moneyBackGuarantee, Warranty expressWarranty) {
        if (moneyBackGuarantee == null) {
            throw new IllegalArgumentException();
        }
        if (expressWarranty == null) {
            throw new IllegalArgumentException();
        }

        this.moneyBackGuarantee = moneyBackGuarantee;
        this.expressWarranty = expressWarranty;
    }

    /**
     * Do not return null
     * @return
     */
    public Warranty getMoneyBackGuarantee() {
        return moneyBackGuarantee;
    }

    public Warranty getExpressWarranty() {
        return expressWarranty;
    }
}
