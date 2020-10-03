package com.bergaz.fundamentals.iteration_one.core.collections.production;

public interface ProductLookupTable {

    Product lookupById(int id);

    void addProduct(Product product);

    void clear();
}
