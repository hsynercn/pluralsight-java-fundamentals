package com.bergaz.fundamentals.iteration_one.collections_2020_version;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionConcepts {
    public static void main(String[] args) {
        Product door = new Product("Wooden Door", 35, 1);
        Product floorPanel = new Product("Floor Panel", 25, 2);
        Product window = new Product("Glass Window", 10, 3);

        /**
         * Java collections api provides a large builtin function set
         */
        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(door);
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        products.stream().forEach(System.out::println);

        /**
         * We get a ConcurrentModificationException from remove function
         */
        for (Product product : products) {
            if (product.getWeight() > 20) {
                //products.remove(product);
            }
        }

        /**
         * A better way for removing an element
         */
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            System.out.println(product);
            if (product.getWeight() > 80) {
                //products.remove(product);//same as below
                iterator.remove();
            }
        }

        System.out.println(products.size());
        System.out.println(products.isEmpty());
        System.out.println(products.contains(window));
        System.out.println(products.remove(window));
        System.out.println(products.contains(window));

        Collection<Product> remove = new ArrayList<>();
        remove.add(door);

        products.removeAll(remove);
        products.stream().forEach(System.out::println);

    }
}
