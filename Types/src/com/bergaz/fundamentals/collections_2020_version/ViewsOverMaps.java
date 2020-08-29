package com.bergaz.fundamentals.collections_2020_version;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewsOverMaps {
    public static void main(String[] args) {
        Map<Integer, Product> idToProduct = new HashMap<>();
        Product door = new Product("Wooden Door", 35, 1);
        Product floorPanel = new Product("Floor Panel", 25, 2);
        Product window = new Product("Glass Window", 10, 3);

        idToProduct.put(door.getId(), door);
        idToProduct.put(floorPanel.getId(), floorPanel);
        idToProduct.put(window.getId(), window);

        /**
         * 1st VIEW
         * Keys view
         */
        Set<Integer> ids = idToProduct.keySet();
        System.out.println(ids);
        System.out.println(idToProduct);

        System.out.println("Full product set:");
        for (Integer id : ids) {
            System.out.println("key:" + id + " value:" + idToProduct.get(id));
        }

        /**
         * We get a UnsupportedOperationException for this line
         * We can't add a new key without value
         */
        //ids.add(4);

        /**
         * But we can remove a key
         */
        ids.remove(1);

        System.out.println("Set after removing key 1:");
        for (Integer id : ids) {
            System.out.println("key:" + id + " value:" + idToProduct.get(id));
        }

        /**
         * 2nd VIEW
         * Values view
         */
        Collection<Product> products = idToProduct.values();
        products.remove(floorPanel);

        System.out.println("Set after floor panel:");
        for (Integer id : ids) {
            System.out.println("key:" + id + " value:" + idToProduct.get(id));
        }

        /**
         * 3rd VIEW
         * Both of them
         */

        idToProduct.put(door.getId(), door);
        idToProduct.put(floorPanel.getId(), floorPanel);

        Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet();
        for (Map.Entry<Integer, Product> entry : entries) {
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            /**
             * We can change entry values
             */
            entry.setValue(door);
        }

        System.out.println("Set all of them DOOR:");
        System.out.println(idToProduct);

    }
}
