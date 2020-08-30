package com.bergaz.fundamentals.collections_2020_version;

import java.util.*;

public class ProductCatalog implements Iterable<Product>{

    private Set<Product> products = new HashSet<>();

    public void addSupplier(Supplier supplier) {
        products.addAll(supplier.getProducts());
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
