package com.bergaz.fundamentals.iteration_one.moreobjectoriented.specialcaseobject;

import java.time.Duration;
import java.time.LocalDate;

public class TimeLimitedWarranty implements Warranty{
    private LocalDate dateIssued;
    private Duration validFor;

    public TimeLimitedWarranty(LocalDate dateIssued, Duration validFor) {
        this.dateIssued = dateIssued;
        this.validFor = validFor;
    }

    /*@Override
    public boolean isValidOd(LocalDate date) {
        return this.dateIssued.compareTo(date) <= 0 &&
                this.getExpiredDate().compareTo(date) > 0;
    }*/

    @Override
    public Warranty on(LocalDate date) {
        return date.compareTo(this.dateIssued) < 0 ? Warranty.VOID
                : date.compareTo(this.getExpiredDate()) > 0 ? Warranty.VOID
                :this;
    }

    public LocalDate getExpiredDate() {
        return this.dateIssued.plusDays(this.getValidForDays());
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public long getValidForDays() {
        return validFor.toDays();
    }

    public Duration getValidFor() {
        return validFor;
    }
}
