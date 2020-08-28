package com.bergaz.fundamentals.collections_2020_version;

import java.util.Comparator;

public class Product {
    public static final Comparator<Product> BY_WEIGHT =
            Comparator.comparingInt(Product::getWeight);
    private final String name;
    private final int weight;
    private final int id;

    public Product(String name, int weight, int id) {
        this.name = name;
        this.weight = weight;
        this.id = id;
    }

    public int getId() {
        return id;
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
