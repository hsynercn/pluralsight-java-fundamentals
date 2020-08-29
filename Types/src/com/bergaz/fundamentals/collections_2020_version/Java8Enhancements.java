package com.bergaz.fundamentals.collections_2020_version;

import java.util.HashMap;
import java.util.Map;

public class Java8Enhancements {
    public static void main(String[] args) {
        Product defaultProduct = new Product("Test", 100, 1);

        Product door = new Product("Wooden Door", 35, 1);
        Product floorPanel = new Product("Floor Panel", 25, 2);
        Product window = new Product("Glass Window", 10, 3);

        Map<Integer, Product> idToProduct = new HashMap<>();

        idToProduct.put(defaultProduct.getId(), door);
        idToProduct.put(floorPanel.getId(), floorPanel);
        idToProduct.put(window.getId(), window);

        /**
         * J8:Getting value with default
         */
        Product product = idToProduct.get(4);
        System.out.println("4:" + idToProduct.get(4));
        System.out.println("4:" + idToProduct.getOrDefault(4, defaultProduct));

        idToProduct.replace(1, new Product("Big Door", 45, 1));

        idToProduct.replaceAll((id, productVal) -> {
            return new Product("BIG " + productVal.getName(), productVal.getWeight(), id);
        });

        System.out.println("After replace all:");
        System.out.println(idToProduct);

        idToProduct.computeIfAbsent(10, id ->{
            return new Product("Door Handle", 5, 10);
        });

        System.out.println("After compute if absent:");
        System.out.println(idToProduct);

        idToProduct.forEach((id, productVal) ->{
            System.out.println(productVal.getName() + " id " + productVal.getId());
        });
    }
}
