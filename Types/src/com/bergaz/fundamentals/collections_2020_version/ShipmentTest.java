package com.bergaz.fundamentals.collections_2020_version;


import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ShipmentTest {
    public static Product door = new Product("Wooden Door", 35);
    public static Product floorPanel = new Product("Floor Panel", 25);
    public static Product window = new Product("Glass Window", 10);

    private Shipment shipment = new Shipment();

    @Test
    public void shouldAddItems() {
        shipment.add(door);
        shipment.add(window);
        assertTrue(shipment.contains(door));
        assertTrue(shipment.contains(window));
    }
}
