package com.bergaz.collections.production;

import java.util.*;

public class ProductCatalogue implements Iterable<Product> {

    private final SortedSet<Product> productSortedSet = new TreeSet<>(Product.BY_WEIGHT);

    private final Set<Product> products = new HashSet<>();

    private final Set<Product> productSet = new TreeSet<>(Product.BY_WEIGHT);

    public void isSuppliedBy(Supplier supplier) {
        products.addAll(supplier.products());
    }
    @Override
    public Iterator<Product> iterator() {
        return null;
    }

    public Set<Product> lightVanProducts() {
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();
        return productSortedSet.headSet(heaviestLightVanProduct);
    }

    private Product findHeaviestLightVanProduct() {
        for(Product product : productSortedSet) {
            if(product.getWeight() > 20) {
                return product;
            }
        }
        return productSortedSet.last();
    }

    public Set<Product> heavyVanProducts() {
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();
        return productSortedSet.tailSet(heaviestLightVanProduct);
    }
}
