package com.example.demojpa3.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;
/**
 * Reprezentarea digitala a informatiilor trimise de la frontend la backend
 * Se aleg strict informatiile de care avem nevoie din front
 * "Schelet" pentru entitate
 * Se ocupa de creearea/ stergerea/ modificarea comenzilor(Orders)
 */
public class OrdersDto implements Serializable {

    private Long userId;

    private Long id;//order id
    private Long priceTotal;
    private  String details;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrdersDto(Long userId, Long orderId, Long priceTotal, String details) {
        this.userId = userId;
        this.id = orderId;
        this.priceTotal = priceTotal;
        this.details = details;
    }


    public Long getOrderId() {
        return id;
    }

    public void setOrderId(Long orderId) {
        this.id = orderId;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @JsonIgnore
    public boolean checkEmptyField(){

        return  this.priceTotal==null || this.details==null;

    }

    public void setPriceTotal(Long priceTotal) {
        this.priceTotal = priceTotal;
    }



    public Long getPriceTotal() {
        return priceTotal;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersDto entity = (OrdersDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.priceTotal, entity.priceTotal) &&
                Objects.equals(this.details, entity.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, priceTotal, details);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "priceTotal = " + priceTotal + ", " +
                "details = " + details + ")";
    }
}
