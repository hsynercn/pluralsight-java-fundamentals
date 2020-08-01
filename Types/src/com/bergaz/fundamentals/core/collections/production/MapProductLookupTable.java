package com.bergaz.fundamentals.core.collections.production;

import java.util.HashMap;
import java.util.Map;

public class MapProductLookupTable implements ProductLookupTable{

    private final Map<Integer, Product> idToPrduct = new HashMap<>();

    @Override
    public Product lookupById(int id) {
        return idToPrduct.get(id);
    }

    @Override
    public void addProduct(Product productToAdd) {
        if(!idToPrduct.containsKey(productToAdd.getId())) {
            idToPrduct.put(productToAdd.getId(), productToAdd);
        } else {
            throw new IllegalArgumentException("Unable to add product, duplicate product id.");
        }
    }

    @Override
    public void clear() {
        idToPrduct.clear();
    }
}
