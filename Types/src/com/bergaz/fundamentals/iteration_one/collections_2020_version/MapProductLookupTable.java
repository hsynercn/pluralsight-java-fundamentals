package com.bergaz.fundamentals.iteration_one.collections_2020_version;

import java.util.HashMap;
import java.util.Map;

public class MapProductLookupTable implements ProductLookupTable{

    private Map<Integer, Product> integerProductMap = new HashMap<>();

    @Override
    public Product lookupById(int id) {
        return integerProductMap.get(id);
    }

    @Override
    public void addProduct(Product productToAdd) {
        if (integerProductMap.containsKey(productToAdd.getId())) {
            throw new IllegalArgumentException("Duplicate id: " + productToAdd.getId());
        }
        integerProductMap.put(productToAdd.getId(), productToAdd);
    }

    @Override
    public void clear() {
        integerProductMap.clear();
    }
}
