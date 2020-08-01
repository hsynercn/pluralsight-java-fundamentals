package com.bergaz.fundamentals.core.collections.production;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product> {
    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    private static final int PRODUCT_NOT_PRESENT = -1;

    private final List<Product> products = new ArrayList<Product>();
    private List<Product> heavyVanProducts;
    private List<Product> lightVanProducts;

    public void add(Product product) {
        products.add(product);
    }

    public void replace(Product oldProduct, Product newProduct) {
        int index = products.indexOf(oldProduct);
        if(index != PRODUCT_NOT_PRESENT) {
            products.set(index, newProduct);
        }
    }

    public void prepare() {
        products.sort(Product.BY_WEIGHT);

        int splitPoint = findSplitPoint();

        lightVanProducts = products.subList(0, splitPoint);
        heavyVanProducts = products.subList(splitPoint, products.size());
    }

    public static int getLightVanMaxWeight() {
        return LIGHT_VAN_MAX_WEIGHT;
    }

    public static int getProductNotPresent() {
        return PRODUCT_NOT_PRESENT;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getHeavyVanProducts() {
        return heavyVanProducts;
    }

    public List<Product> getLightVanProducts() {
        return lightVanProducts;
    }

    private int findSplitPoint() {
        for(int i = 0; i < products.size(); i++) {
            if (products.get(i).getWeight() > LIGHT_VAN_MAX_WEIGHT) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public Iterator<Product> iterator() {
        return this.products.iterator();
    }
}
