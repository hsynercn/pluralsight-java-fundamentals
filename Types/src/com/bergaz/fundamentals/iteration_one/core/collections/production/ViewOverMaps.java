package com.bergaz.fundamentals.iteration_one.core.collections.production;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewOverMaps {
    public static void main(String[] args) {
        final Map<Integer, Product> idToProduct = new HashMap<>();

        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);

        String productStr = idToProduct.toString();

        final Set<Integer> keys = idToProduct.keySet();
        keys.remove(1);

        String productStr2 = idToProduct.toString();

        Collection<Product> products = idToProduct.values();

        products.remove(ProductFixtures.floorPanel);

        String productStr3 = idToProduct.toString();

        Set<Map.Entry<Integer, Product>> entrySet = idToProduct.entrySet();
        //System.out.println(entrySet);

        idToProduct.put(12, ProductFixtures.floorPanel);
        idToProduct.put(13, ProductFixtures.window);

        for(Map.Entry<Integer, Product> entry: idToProduct.entrySet()) {
            System.out.println(entry.getKey() + " -> " +entry.getValue());
        }
    }
}
