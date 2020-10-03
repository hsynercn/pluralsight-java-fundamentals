package com.bergaz.fundamentals.iteration_one.core.collections.production;

import java.util.HashMap;
import java.util.Map;

public class Java8Enhancements {
    public static void main(String[] args) {

        final Product defaultProduct = new Product("Default", 0, -1 );

        final Map<Integer, Product> idToProduct = new HashMap<>();

        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);

        Product res = idToProduct.getOrDefault(10, defaultProduct);

        //does not update, absent key
        idToProduct.replace(4, new Product("New big door", 50, 4 ));

        idToProduct.replaceAll((id, oldProduct) ->
                new Product(oldProduct.getName(), oldProduct.getWeight() + 25, id));

        System.out.println(idToProduct);

    }
}
