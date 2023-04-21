package com.example.demojpa3.Dto;

/**
 * Reprezentarea digitala a informatiilor trimise de la frontend la backend
 * Se aleg strict informatiile de care avem nevoie din front
 */

public class UserUpdateDto {

    private String name;

    private String email;

    private String role;

    private String adress;

    private String car;


    public UserUpdateDto(String name, String email, String role, String adress, String car) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.adress = adress;
        this.car = car;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
