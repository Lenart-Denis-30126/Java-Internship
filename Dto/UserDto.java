package com.example.demojpa3.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
/**
 * Reprezentarea digitala a informatiilor trimise de la frontend la backend
 * Se aleg strict informatiile de care avem nevoie din front
 * "Schelet" pentru entitate
 * Se ocupa de creearea/ stergerea/ modificarea utilizatorilor(Users)
 */
public class UserDto {

    private Long id;
    private String name;

    private String username;

    private String password;

    private String email;

    private String car;

    private String role;

    private String adress;

    private String phonenumber;

    private String country;

    private String state;

    private String engine;

    @JsonIgnore
    public boolean checkEmptyField(){

        return this.name==null || this.username==null || this.password==null || this.email==null || this.car==null || this.role==null || this.adress==null || this.country == null || this.state == null || this.engine == null;

    }

    public UserDto() {
    }

    public UserDto(Long id,String name, String username, String password, String email, String car, String role, String adress, String phonenumber, String country, String state, String engine) {
        this.id=id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.car = car;
        this.role = role;
        this.adress = adress;
        this.phonenumber=phonenumber;
        this.country=country;
        this.state=state;
        this.engine=engine;

    }

    public UserDto(String name, String username, String email, String car, String adress, String phonenumber, String country, String state, String engine) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.car = car;
        this.adress = adress;
        this.phonenumber = phonenumber;
        this.country = country;
        this.state = state;
        this.engine = engine;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
