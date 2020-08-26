package com.bergaz.fundamentals.collections_2020_version;

import java.util.Comparator;

public class Product {
    public static final Comparator<Product> BY_WEIGHT =
            Comparator.comparingInt(Product::getWeight);
    private final String name;
    private final int weight;

    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', weight=" + weight + "}";
    }
}
