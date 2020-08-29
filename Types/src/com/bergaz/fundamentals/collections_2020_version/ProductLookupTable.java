package com.bergaz.fundamentals.collections_2020_version;

public interface ProductLookupTable {
    Product lookupById(int id);
    void addProduct(Product productToAdd);
    void clear();
}
