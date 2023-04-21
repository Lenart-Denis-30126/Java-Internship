package com.example.demojpa3.Entity;


import org.apache.catalina.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



/**
 * Reprezentarea digitala a informatiilor necesare-Entitate
 */
@Entity
@Table(name="users")
public class Users {



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "refUser",cascade=CascadeType.ALL)
    Set<Orders> orders= new HashSet<>();



    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false, unique = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "car", nullable = false, unique = false)
    private String car;

    @Column(name = "role", nullable = false, unique = false)
    private String role;

    @Column(name = "adress", nullable = false, unique = false)
    private String adress;

    @Column(name = "phonenumber", nullable = false, unique = false)
    private String phonenumber;

    @Column(name = "country", nullable = false, unique = false)
    private String country;

    @Column(name = "state", nullable = false, unique = false)
    private String state;

    @Column(name = "engine", nullable = false, unique = false)
    private String engine;

    public Users(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users() {}

    public Users(String name, String username, String password, String email, String car, String role, String adress, String phonenumber, String country, String state, String engine) {

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

//    public long getId() {
//        return id;
//    }


    public Users(String name, String username, String email, String car, String adress, String phonenumber, String country, String state, String engine) {
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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
