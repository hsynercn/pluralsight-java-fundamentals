package com.bergaz.fundamentals.core.collections.production;

public interface ProductLookupTable {

    Product lookupById(int id);

    void addProduct(Product product);

    void clear();
}
