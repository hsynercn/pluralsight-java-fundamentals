package com.bergaz.fundamentals.collections_2020_version;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableVsImmutable {
    public static void main(String[] args) {
        Map<String, Integer> mutableCountryToPopulation = new HashMap<>();

        mutableCountryToPopulation.put("UK", 67);
        mutableCountryToPopulation.put("USA", 328);

        /**
         * Changes are not reflected
         */
        Map<String, Integer> copyOfMutableCountryToPopulation = Map.copyOf(mutableCountryToPopulation);

        Map<String, Integer> unmodifiableCountryToPop = Collections.unmodifiableMap(mutableCountryToPopulation);

        /**
         * We get an exception for this
         */
        //unmodifiableCountryToPop.put("Germany", 83);

        mutableCountryToPopulation.put("Germany", 83);
        /**
         * Change reflected to unmodifiable map
         */
        System.out.println("mutableCountryToPopulation: " + mutableCountryToPopulation);
        System.out.println("unmodifiableCountryToPop: " + unmodifiableCountryToPop);
        System.out.println("copyOfMutableCountryToPopulation: " + copyOfMutableCountryToPopulation);

        /**
         * Map.of method generates a unmodifiable map
         */
        Map<String, Integer> shortVersion = Map.of("UK", 67, "USA", 328);
        //shortVersion.put("Test", 1);
        System.out.println(shortVersion);

        /**
         * We can use unmodifiable copies for exposing the list or map to other classes
         * They can read the data but can't change it
         */
    }
}
