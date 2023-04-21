package com.example.demojpa3.Service;

import com.example.demojpa3.Entity.Users;
import com.example.demojpa3.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserLogInService implements UserDetailsService{

    @Autowired
    private UsersRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userRes = userRepo.findByUsername(username);
        if(userRes == null)
            throw new UsernameNotFoundException("Could not findUser with email = " + username);

        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userRes.getRole()));

        return org.springframework.security.core.userdetails.User.withUsername(userRes.getUsername())
                .password(userRes.getPassword())
                .authorities(authorities).build();
    }
}


