package com.bergaz.fundamentals.iteration_one.collections_2020_version;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
    private String name;
    private List<Product> products = new ArrayList<>();

    public Supplier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Supplier name:" + this.name + " products: " +  products;
    }
}
