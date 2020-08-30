package com.bergaz.fundamentals.moreobjectoriented.obsoletebooleanflags.goodimplementation;

public class PrinterAccountUnfrozen implements AccountUnfrozen{
    @Override
    public void handle() {
        System.out.println("PrinterAccountUnfrozen handle");
    }
}
