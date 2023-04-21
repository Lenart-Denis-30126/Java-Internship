package com.example.demojpa3.Dto;

import java.io.Serializable;
import java.util.Objects;
/**
 * Reprezentarea digitala a informatiilor trimise de la frontend la backend
 *
 * Se aleg strict informatiile de care avem nevoie din front
 *
 * "Schelet" pentru entitate
 *
 * Se ocupa de link-uirea relatiei de many-to-many-> se creeaza relatii de tip one-to-many respectiv many-to-one
 */
public class OrdersToProductsDto implements Serializable {
    private long id;
    private long quantity;

    public OrdersToProductsDto(long id, long quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public long getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersToProductsDto entity = (OrdersToProductsDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.quantity, entity.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "quantity = " + quantity + ")";
    }
}
