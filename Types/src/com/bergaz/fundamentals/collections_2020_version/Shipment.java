package com.bergaz.fundamentals.collections_2020_version;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product>{

    private static final int LIGHT_VAN_WEIGHT = 20;
    private static final int MISSING_ITEM = -1;

    private final List<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }

    public boolean replace(Product oldProduct, Product newProduct) {
        int position = products.indexOf(oldProduct);
        if (position == MISSING_ITEM) {
            return false;
        } else {
            products.set(position, newProduct);
            return true;
        }
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    public boolean contains(Product product) {
        return products.contains(product);
    }

    public List<Product> getHeavyVanProducts() {
        return null;
    }

    public List<Product> getLighgtVanProducts() {
        return null;
    }

    public void prepare() {
        products.sort(Product.BY_WEIGHT);
    }

}
