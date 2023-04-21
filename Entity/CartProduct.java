//package com.example.demojpa3.Entity;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//
//@Entity
//@Table(name="cart_product")
//public class CartProduct {
//
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private long id;
//
//    @ManyToOne
//    @JoinColumn(name="ref_user")
//    private Users ref_user;
//
//    @ManyToOne
//    @JoinColumn(name="ref_product")
//    private Products ref_product;
//
//    @Column(name = "quantity", nullable = false, unique = false)
//    private int quantity;
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public Users getRef_user() {
//        return ref_user;
//    }
//
//    public Products getRef_product() {
//        return ref_product;
//    }
//
//
//}
