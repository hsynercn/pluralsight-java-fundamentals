package com.bergaz.fundamentals.iteration_one.core.collections.production;

public class ProductFixtures {
    public static Product door = new Product("Wooden Door", 35, 1);
    public static Product floorPanel = new Product("Floor Panel", 25, 2);
    public static Product window = new Product("Glass Window", 10, 3);

    public static Supplier bobs = new Supplier("Bob's Household Supplies");
    public static Supplier kates = new Supplier("Kate's Household Supplies");

    static {
        bobs.products().add(door);
        bobs.products().add(floorPanel);

        kates.products().add(floorPanel);
        kates.products().add(door);
    }

}
