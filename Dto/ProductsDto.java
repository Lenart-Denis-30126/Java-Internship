package com.example.demojpa3.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;
/**
 * Reprezentarea digitala a informatiilor trimise de la frontend la backend
 * Se aleg strict informatiile de care avem nevoie din front
 * "Schelet" pentru entitate
 * Se ocupa de creearea/ stergerea/ modificarea produselor(Products)
 */
public class ProductsDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Long stock;
    private Long price;

    private String logo;

    @JsonIgnore
    public boolean checkEmptyField(){

        return this.name==null || this.description==null || this.stock==null || this.price==null;

    }

    public ProductsDto(Long id, String name, String description, Long stock, Long price, String logo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.logo = logo;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getStock() {
        return stock;
    }

    public Long getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsDto entity = (ProductsDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.stock, entity.stock) &&
                Objects.equals(this.price, entity.price);
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, stock, price);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "description = " + description + ", " +
                "stock = " + stock + ", " +
                "price = " + price + ")";
    }


}
