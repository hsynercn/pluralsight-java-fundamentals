package com.bergaz.fundamentals.iteration_one.collections_2020_version;

import java.util.ArrayList;
import java.util.List;

public class NativeProductLookupTable implements ProductLookupTable {

    private final List<Product> products = new ArrayList<>();

    @Override
    public Product lookupById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void addProduct(Product productToAdd) {
        for (Product product : products) {
            if (product.getId() == productToAdd.getId()) {
                throw new IllegalArgumentException("Duplicate id: " + productToAdd.getId());
            }
        }
        products.add(productToAdd);
    }

    @Override
    public void clear() {
        products.clear();
    }
}
