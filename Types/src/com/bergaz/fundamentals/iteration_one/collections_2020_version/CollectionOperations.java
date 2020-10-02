package com.bergaz.fundamentals.iteration_one.collections_2020_version;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionOperations {
    public static void main(String[] args) {
        Product door = new Product("Wooden Door", 35, 1);
        Product floorPanel = new Product("Floor Panel", 25, 2);
        Product window = new Product("Glass Window", 10, 3);

        List<Product> products = List.of(door, floorPanel, window);

        Product min = Collections.min(products, Product.BY_WEIGHT);
        Product max = Collections.max(products, Product.BY_WEIGHT);

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

        ArrayList<Product> productArrayList = new ArrayList<>();
        productArrayList.addAll(products);

    }

}
