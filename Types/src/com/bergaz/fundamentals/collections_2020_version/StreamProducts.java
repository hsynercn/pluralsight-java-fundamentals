package com.bergaz.fundamentals.collections_2020_version;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamProducts {
    public static void main(String[] args) {
        Product door = new Product("Wooden Door", 35, 1);
        Product floorPanel = new Product("Floor Panel", 25, 2);
        Product window = new Product("Glass Window", 10, 3);

        List<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);
        products.add(floorPanel);
        products.add(window);

        //namesOfLightProductsWeightSortedLoop(products);
        namesOfLightProductsWeightStream(products);

    }

    private static void namesOfLightProductsWeightStream(List<Product> products) {
        products
                .stream()
                .filter(product -> product.getWeight() < 30)
                .sorted(Comparator.comparingInt(Product::getWeight))
                .map(product -> product.getName() + " - " + product.getId())
                .forEach(System.out::println);
    }

    private static void namesOfLightProductsWeightSortedLoop(List<Product> products) {
        List<Product> lightProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getWeight() < 30) {
                lightProducts.add(product);
            }
        }

        lightProducts.sort(Comparator.comparingInt(Product::getWeight));

        for (Product product : lightProducts) {
            System.out.println(product.getName());
        }
    }
}
