package com.bergaz.fundamentals.iteration_one.moreobjectoriented.intro;

public class LackOfObjectsMain {
    public static void main(String[] args) {

    }

    /**
     * After some changes we can see actually we don't need a
     * function for summing.
     * Advice:
     * We should not implement functions for operations for a
     * used object. We can ask a service for this operation.
     * This is a consumer class.
     * At the end we can delete this function.
     * @param values
     * @return
     */
    /*
    public int sum(int[] values, selector) {

    }
    */

    /**
     * We implemented a sum function for customer needs, but this  solution
     * will not hold too long. In future we get different requests from customer.
     * Like summing only odd number or even numbers etc.
     * Inside of the loop is a bad place for hard-coded logic.
     * We are risking the previous functions by changing this code.
     * Advice:
     * Do not change code to modify behavior
     * Try to substitute an object with a different behavior
     * @param values
     * @return
     */
    public int sum(int[] values, boolean oddNumbersOnly) {
        int sum = 0;
        for (int value : values) {
            if(oddNumbersOnly || value % 2 != 0) {
                sum += value;
            }
        }
        return sum;
    }
}
