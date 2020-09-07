package com.bergaz.fundamentals.moreobjectoriented.specialcaseobject;

import java.time.LocalDate;

public class VoidWarranty implements Warranty {
    /*@Override
    public boolean isValidOd(LocalDate date) {
        return false;
    }*/

    @Override
    public Warranty on(LocalDate date) {
        return this;
    }

    /**
     * For only VoidWarranty we have implemented a claim method other than default
     * @param action
     */
    @Override
    public void claim(Runnable action) {

    }
}
