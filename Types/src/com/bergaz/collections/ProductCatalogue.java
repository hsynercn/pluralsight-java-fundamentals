package com.bergaz.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ProductCatalogue implements Iterable<Product> {

    private final Set<Product> products = new HashSet<>();

    private final Set<Product> productSet = new TreeSet<>(Product.BY_WEIGHT);

    public void isSuppliedBy(Supplier supplier) {
        products.addAll(supplier.products());
    }
    @Override
    public Iterator<Product> iterator() {
        return null;
    }
}
