package com.bergaz.fundamentals.collections.production;

public interface ProductLookupTable {

    Product lookupById(int id);

    void addProduct(Product product);

    void clear();
}
