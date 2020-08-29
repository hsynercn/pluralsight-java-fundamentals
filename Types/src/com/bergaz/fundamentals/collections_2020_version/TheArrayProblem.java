package com.bergaz.fundamentals.collections_2020_version;

import java.util.Arrays;

public class TheArrayProblem {
    public static void main(String[] args) {
        Product door = new Product("Wooden Door", 35, id);
        Product floorPanel = new Product("Floor Panel", 25, id);
        Product window = new Product("Glass Window", 10, id);

        Product[] products = {door, floorPanel};

        /**
         * First problem with arrays, they are not human friendly
         * This is not a human friendly string
         */
        System.out.println(products);

        /**
         * This is much better
         */
        System.out.println(Arrays.toString(products));

        /**
         * Second problem, arrays are fixed length
         */
        //products[2] = window;

        /**
         * We can use a method to expand existing array
         * Because arrays are low level programming construct
         * We need to implement out custom functionality
         */
        products = add(window, products);
        System.out.println(Arrays.toString(products));

        products = add(window, products);
        System.out.println(Arrays.toString(products));

    }

    private static Product[] add(Product product, Product[] products) {
        int length = products.length;
        Product[] newArray = Arrays.copyOf(products, length+1);
        newArray[length] = product;
        return newArray;
    }
}
