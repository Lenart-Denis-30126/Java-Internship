package com.example.demojpa3.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RegisterCredentialsDto {


    private String name;
    private String car;

    private String adress;
    private String username;

    private String email;

    private String password;

    @JsonIgnore
    public boolean checkEmptyField(){

        return this.username==null || this.email==null || this.password==null;

    }


    public RegisterCredentialsDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
