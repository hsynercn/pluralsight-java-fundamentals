package com.bergaz.collections.production;

import java.util.ArrayList;

public class NaiveProductLookupTable implements ProductLookupTable{

    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public Product lookupById(int id) {
        for (Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void addProduct(Product productToAdd) {
        for (Product product : products) {
            if(product.getId() == productToAdd.getId()) {
                throw new IllegalArgumentException("Unable to add product, duplicate product id.");
            }
        }
        products.add(productToAdd);
    }

    @Override
    public void clear() {
        products.clear();
    }
}
