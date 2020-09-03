package com.bergaz.fundamentals.moreobjectoriented.specialcaseobject;

import java.time.LocalDate;

public interface Warranty {
    boolean isValidOd(LocalDate date);

    /**
     * Interface variables are static final by definition
     */
    Warranty VOID = new VoidWarranty();
}
