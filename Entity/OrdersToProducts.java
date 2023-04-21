package com.example.demojpa3.Entity;

import javax.persistence.*;


/**
 * Reprezentarea digitala a informatiilor necesare-Entitate
 */

@Entity
@Table(name="orders_products")
public class OrdersToProducts {

    @Id
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Orders ref_order;

    @ManyToOne(cascade = CascadeType.ALL)
    private Products ref_product;

    private long quantity;

    public OrdersToProducts() {
    }

    public OrdersToProducts(long quantity) {
        this.quantity = quantity;
    }

    public OrdersToProducts(long id, long quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public OrdersToProducts(Orders ref_order, Products ref_product, long quantity) {
        this.ref_order = ref_order;
        this.ref_product = ref_product;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Orders getRef_order() {
        return ref_order;
    }

    public void setRef_order(Orders ref_order) {
        this.ref_order = ref_order;
    }

    public Products getRef_product() {
        return ref_product;
    }

    public void setRef_product(Products ref_product) {
        this.ref_product = ref_product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
