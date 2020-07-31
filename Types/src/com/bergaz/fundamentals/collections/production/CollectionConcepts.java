package com.bergaz.fundamentals.collections.production;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionConcepts {
    public static void main(String[] args) {
        Product door = new Product("Wooden Door", 35, 1);
        Product floorPanel = new Product("Floor Panel", 25, 2);
        Product window = new Product("Glass Window", 10, 3);

        Collection<Product> products;
        products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        final Iterator<Product> productIterator = products.iterator();

        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if(product.getWeight() > 20) {
                System.out.println(product);
            } else {
                productIterator.remove();
            }
        }

        //We cannot modify the list with a foreach loop
        for(Product product : products) {
            System.out.println(product);
        }

        int size = products.size();
        boolean isEmpty = products.isEmpty();
        boolean containsWindow = products.contains(window);
        boolean containsDoor = products.contains(door);

        String proStr = products.toString();
    }

}
