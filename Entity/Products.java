package com.example.demojpa3.Entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Reprezentarea digitala a informatiilor necesare-Entitate
 */

@Entity
@Table(name="products")
public class Products {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy="ref_product")
    Set<OrdersToProducts> orders= new HashSet<>();

//    @OneToMany(mappedBy="ref_product", cascade=CascadeType.ALL)
//    Set<CartProduct> cart= new HashSet<>();

    @Column(name = "name", nullable = false, unique = false)
    private String name;


    @Column(name = "description", nullable = false, unique = false)
    private String description;


    @Column(name = "stock", nullable = false, unique = false)
    private Long stock;


    @Column(name = "price", nullable = false, unique = false)
    private Long price;

    @Column(name = "logo", nullable = false, unique = false)
    private String logo;

    public Long getId() {
        return id;
    }

    public Products() {
    }

    public Products(String name, String description, Long stock, Long price, String logo) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.logo = logo;
    }

    public Products(String name, String description, Long stock, Long price) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
