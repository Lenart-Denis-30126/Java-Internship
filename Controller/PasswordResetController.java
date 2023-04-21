package com.example.demojpa3.Controller;

import com.example.demojpa3.Dto.UserDto;
import com.example.demojpa3.Entity.PasswordResetToken;
import com.example.demojpa3.Entity.Users;
import com.example.demojpa3.Repository.UsersRepository;
import com.example.demojpa3.Service.PasswordResetService;
import com.example.demojpa3.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.UUID;

@RestController
public class PasswordResetController {


    @Autowired
    UsersService usersService;
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    MailSender mailSender;

    @Autowired
    PasswordResetService passwordResetService;




    private UserDto toDto(Users user)
    {
        return new UserDto(user.getId(),user.getName(),user.getUsername(),user.getPassword(),user.getEmail(),user.getCar(), user.getRole(), user.getAdress(),user.getPhonenumber(),user.getCountry(),user.getState(),user.getEngine());
    }

    @GetMapping("/user/resetPassword")
    public ResponseEntity<String> resetPassword( @RequestParam("email") String userEmail) throws ChangeSetPersister.NotFoundException {
        Users user = usersRepository.findByEmail(userEmail);
        toDto(user);
        if (user == null) {
            throw new ChangeSetPersister.NotFoundException();
        }
        String token = UUID.randomUUID().toString();
        usersService.createPasswordResetTokenForUser(user, token);
        mailSender.send(passwordResetService.constructResetTokenEmail(token, user));
        return new ResponseEntity<>("Mail sent successfully!", HttpStatus.OK);


    }




//    @PutMapping("/user/verifyPasswordToken")
//    public ResponseEntity<String> resetPassword(@RequestParam(token) String token)
//


}
