package com.example.demojpa3.Controller;

import com.example.demojpa3.Dto.LogInCredentialsDto;
import com.example.demojpa3.Dto.RegisterCredentialsDto;
import com.example.demojpa3.Dto.UserDto;
import com.example.demojpa3.Entity.Users;
import com.example.demojpa3.Repository.UsersRepository;
import com.example.demojpa3.Security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired private UsersRepository userRepo;


    @Autowired private JWTUtil jwtUtil;

     private AuthenticationManager authManager;
     private PasswordEncoder passwordEncoder;


    @Autowired
    public AuthController(AuthenticationManager authManager, PasswordEncoder passwordEncoder) {
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
    }



    @PostMapping("/register")
    public Map<String, Object> registerHandler(@RequestBody Users user){
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        user = userRepo.save(user);
        String token = jwtUtil.generateToken(user.getUsername());
        return Collections.singletonMap("jwt_token", token);
    }

    @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody LogInCredentialsDto body){
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword());

            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(body.getUsername());

            return Collections.singletonMap("jwt_token", token);
        }catch (AuthenticationException authExc){
            throw new RuntimeException("Invalid Login Credentials");
        }
    }



}