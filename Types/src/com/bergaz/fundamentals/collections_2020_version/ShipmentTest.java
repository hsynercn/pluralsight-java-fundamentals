package com.bergaz.fundamentals.collections_2020_version;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShipmentTest {
    public static Product door = new Product("Wooden Door", 35, id);
    public static Product floorPanel = new Product("Floor Panel", 25, id);
    public static Product window = new Product("Glass Window", 10, id);

    private Shipment shipment = new Shipment();

    @Test
    public void shouldAddItems() {
        shipment.add(door);
        shipment.add(window);
        assertTrue(shipment.contains(door));
        assertTrue(shipment.contains(window));
    }

    @Test
    public void replaceItems() {
        shipment.add(door);
        shipment.replace(door, window);
        assertFalse(shipment.contains(door));
        assertTrue(shipment.contains(window));
    }

    @Test
    public void shouldNotReplaceMissingItems() {
        shipment.add(window);
        shipment.replace(door, floorPanel);
        assertFalse(shipment.contains(floorPanel));
    }

    @Test
    public void shouldIdentifyVanRequirements() {
        shipment.add(door);
        shipment.add(window);
        shipment.add(floorPanel);

        shipment.prepare();

        assertTrue(shipment.getHeavyVanProducts().contains(floorPanel));
        assertTrue(shipment.getHeavyVanProducts().contains(door));
        assertTrue(shipment.getLighgtVanProducts().contains(window));
    }
}
