package com.bergaz.fundamentals.moreobjectoriented.specialcaseobject;

import java.time.LocalDate;

public interface Warranty {
    /**
     * We shouldn't teach catching fist to client
     *
     * @param date
     * @return
     */
    //boolean isValidOd(LocalDate date);

    Warranty on(LocalDate date);

    /**
     * We should give fish to client
     */
    default void claim(Runnable action) {
        action.run();
    }

    /**
     * Interface variables are static final by definition
     */
    Warranty VOID = new VoidWarranty();

    static Warranty lifetime(LocalDate issuedOn) {
        return new LifetimeWarranty(issuedOn);
    }
}
