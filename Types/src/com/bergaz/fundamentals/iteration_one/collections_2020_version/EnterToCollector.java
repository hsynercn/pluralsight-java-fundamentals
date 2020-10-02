package com.bergaz.fundamentals.iteration_one.collections_2020_version;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class EnterToCollector {
    public static void main(String[] args) {
        Product door = new Product("Wooden Door", 35, 11);
        Product floorPanel = new Product("Floor Panel", 25, 12);
        Product window = new Product("Glass Window", 10, 13);

        List<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);
        products.add(floorPanel);
        products.add(window);

        products
                .stream()
                .filter(product -> product.getWeight() < 30)
                .sorted(Comparator.comparingInt(Product::getWeight))
                .map(Product::getName)
                .forEach(System.out::println);

        List<Product> lightProducts = products
                .stream()
                .filter(product -> product.getWeight() < 30)
                .sorted(Comparator.comparingInt(Product::getWeight))
                .collect(Collectors.toList());

        System.out.println("Detailed light products:");
        System.out.println(lightProducts);

        Map<String, List<Product>> lightProductMap = products
                .stream()
                .filter(product -> product.getWeight() < 30)
                .sorted(Comparator.comparingInt(Product::getWeight))
                .collect(Collectors.groupingBy(Product::getName));

        System.out.println("Light product map:");
        System.out.println(lightProductMap);

        Map<String, Long> lightProductCounts = products
                .stream()
                .collect(Collectors.groupingBy(Product::getName, counting()));

        System.out.println("Light product count map:");
        System.out.println(lightProductCounts);
    }
}
