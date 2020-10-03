package com.bergaz.fundamentals.iteration_one.collections_2020_version;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product>{

    private static final int LIGHT_VAN_WEIGHT = 20;
    private static final int MISSING_ITEM = -1;

    private final List<Product> products = new ArrayList<>();
    private List<Product> lightVanProducts = new ArrayList<>();
    private List<Product> heavyVanProducts = new ArrayList<>();

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
        return heavyVanProducts;
    }

    public List<Product> getLighgtVanProducts() {
        return lightVanProducts;
    }

    public void prepare() {
        products.sort(Product.BY_WEIGHT);
        int splitPoint = findSplitPoint();
        lightVanProducts = Collections.unmodifiableList(products.subList(0, splitPoint));
        heavyVanProducts = Collections.unmodifiableList(products.subList(splitPoint, products.size()));
    }

    private int findSplitPoint() {
        int size = products.size();
        for (int i = 0; i < size; i++) {
            if (products.get(i).getWeight() > LIGHT_VAN_WEIGHT) {
                return i;
            }
        }
        return 0;
    }

}
