package com.bergaz.fundamentals.iteration_one.moreobjectoriented.specialcaseobject;

public class Article {
    private Warranty moneyBackGuarantee;
    private Warranty expressWarranty;
    private Warranty effectiveExpressWarranty = Warranty.VOID;

    public Article(Warranty moneyBackGuarantee, Warranty expressWarranty) {
        this.moneyBackGuarantee = moneyBackGuarantee;
        this.expressWarranty = expressWarranty;
    }

    /**
     * Constructor should never receive a null value
     * @param moneyBackGuarantee
     * @param expressWarranty
     */
    public Article(Warranty moneyBackGuarantee, Warranty expressWarranty, Warranty effectiveExpressWarranty) {
        if (moneyBackGuarantee == null) {
            throw new IllegalArgumentException();
        }
        if (expressWarranty == null) {
            throw new IllegalArgumentException();
        }

        this.moneyBackGuarantee = moneyBackGuarantee;
        this.expressWarranty = expressWarranty;
        this.effectiveExpressWarranty = effectiveExpressWarranty;
    }

    /**
     * Do not return null
     * @return
     */
    public Warranty getMoneyBackGuarantee() {
        return moneyBackGuarantee;
    }

    public Warranty getExpressWarranty() {
        return effectiveExpressWarranty;
    }

    public Article withVisibleDamage() {
        return new Article(Warranty.VOID, this.expressWarranty, this.effectiveExpressWarranty);
    }

    public Article notOperational() {
        return new Article(Warranty.VOID, this.expressWarranty, this.effectiveExpressWarranty);
    }
}
