package com.bergaz.fundamentals.iteration_one.core.collections.production;

import java.util.Comparator;
import java.util.Objects;

public class Product {
    /**
     * Warburton changed the course
     */
    private final String name;
    private final int weight;
    private final int id;

    public static final Comparator<Product> BY_WEIGHT
            = new Comparator<Product>()
    {
        public int compare(final Product p1, final Product p2)
        {
            return Integer.compare(p1.getWeight(), p2.getWeight());
        }
    };

    public Product(String name, int weight, int id)
    {
        this.name = name;
        this.weight = weight;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getWeight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return weight == product.weight &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }
}
