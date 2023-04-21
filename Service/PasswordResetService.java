package com.example.demojpa3.Service;


import com.example.demojpa3.Dto.UserDto;
import com.example.demojpa3.Entity.PasswordResetToken;
import com.example.demojpa3.Entity.Users;
import com.example.demojpa3.Repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;


import java.util.Calendar;

import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;

@Service
public class PasswordResetService {

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;





    public SimpleMailMessage constructResetTokenEmail(
            String token, Users user) {
        String url = "http://localhost:4200/resetPassword?token=" + token;
        String message = "Salut Reseteazati parola " + url;
        return constructEmail("Reset Password", message + " \r\n" + url, user);
    }

    public SimpleMailMessage constructEmail(String subject, String body,
                                             Users user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getEmail());
        email.setFrom("pitstopoilBot@gmail.com");
        return email;
    }


    public PasswordResetToken findByToken( String token ){

        return passwordResetTokenRepository.findByToken(token);

    }

    public String getToken(String token) throws Exception{
        PasswordResetToken entry=findByToken(token);

        Calendar cal = Calendar.getInstance();
        if(entry.getExpiryDate().before(cal.getTime())) {
            throw new Exception("Token expired!");
        }

        else return token;



    }
}
