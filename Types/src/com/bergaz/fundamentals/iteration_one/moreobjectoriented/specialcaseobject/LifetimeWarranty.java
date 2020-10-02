package com.bergaz.fundamentals.iteration_one.moreobjectoriented.specialcaseobject;

import java.time.LocalDate;

public class LifetimeWarranty implements Warranty{
    private LocalDate issuedOn;

    public LifetimeWarranty(LocalDate issuedOn) {
        this.issuedOn = issuedOn;
    }

    /*@Override
    public boolean isValidOd(LocalDate date) {
        return this.issuedOn.compareTo(date) <= 0;
    }*/

    @Override
    public Warranty on(LocalDate date) {
        return date.compareTo(this.issuedOn) < 0 ? Warranty.VOID : this;
    }
}
