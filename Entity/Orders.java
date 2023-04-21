package com.example.demojpa3.Entity;


import org.apache.catalina.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Reprezentarea digitala a informatiilor necesare-Entitate
 */

@Entity
@Table(name="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy="ref_order")
    Set<OrdersToProducts> products = new HashSet<>();


    @ManyToOne
    @JoinColumn(name="ref_user_id")
    private Users refUser;

    @Column(name = "price_total", nullable = false, unique = false)
    private Long priceTotal;

    @Column(name = "details", nullable = false, unique = false)
    private String details;



    public Orders(Long priceTotal, String details,Users user) {
        this.priceTotal = priceTotal;
        this.details = details;
        refUser = user;
    }

    public Long getId() {
        return id;
    }

    public Orders() {
    }

    public Orders(Long id, Long priceTotal, String details, Users user) {
        this.id = id;
        this.priceTotal = priceTotal;
        this.details = details;
        this.refUser=user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getRefUser() {
        return refUser;
    }

    public void setRef_user(Users ref_user) {
        this.refUser = ref_user;
    }

    public Long getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Long priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}
