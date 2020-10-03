package com.bergaz.fundamentals.iteration_one.collections_2020_version;

import java.util.List;

public class ShipmentBreaker {
    public static void main(String[] args) {
        Product door = new Product("Wooden Door", 35, 1);
        Product floorPanel = new Product("Floor Panel", 25, 2);
        Product window = new Product("Glass Window", 10, 3);

        Shipment shipment = new Shipment();
        shipment.add(door);
        shipment.add(window);
        shipment.add(door);
        shipment.add(window);
        shipment.add(floorPanel);

        shipment.prepare();

        List<Product> lightProducts = shipment.getLighgtVanProducts();
        System.out.println(lightProducts);

        System.out.println("After modification");
        /**
         * We can modify the original data
         * But if we use Collections.unmodifiableList at Shipment class we get a
         * exception at Collections$UnmodifiableCollection.remove
         */
        lightProducts.remove(window);
        lightProducts.remove(window);
        shipment.forEach(product -> System.out.println(product));
    }
}
