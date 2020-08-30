package com.bergaz.fundamentals.moreobjectoriented.intro;

public class UsingObjectsWhereItDoesNotLookPossible {
    public static void main(String[] args) {

    }

    /**
     * We can use a wrapper class for a safer, cleaner implementation
     * @param data
     */
    /*
    public void showItMaybe(MaybeString data) {
        MaybeString upper = sata.toUpperCase();
        String toPrint = upper.orElse("");
        System.out.println(toPrint);
    }
    */

    /**
     * It is a common behaviour to use if else instructions around
     * null conditions even today, we are still branching.
     *
     * @param data
     */
    public void showIt(String data) {
        String upper;
        if (data == null) {
            upper = null;
        } else {
            upper = data.toUpperCase();
        }
        System.out.println(upper);
    }
}
