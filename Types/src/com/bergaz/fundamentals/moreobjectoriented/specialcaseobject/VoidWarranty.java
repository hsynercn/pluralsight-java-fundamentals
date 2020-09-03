package com.bergaz.fundamentals.moreobjectoriented.specialcaseobject;

import java.time.LocalDate;

public class VoidWarranty implements Warranty {
    @Override
    public boolean isValidOd(LocalDate date) {
        return false;
    }
}
