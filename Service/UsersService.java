package com.example.demojpa3.Service;



import com.example.demojpa3.Dto.LogInCredentialsDto;
import com.example.demojpa3.Dto.RegisterCredentialsDto;
import com.example.demojpa3.Dto.UserDto;
import com.example.demojpa3.Entity.PasswordResetToken;
import com.example.demojpa3.Entity.Users;
import com.example.demojpa3.Repository.PasswordResetTokenRepository;
import com.example.demojpa3.Repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordResetTokenRepository passwordResetToken;

    @Autowired
    PasswordResetService passwordResetService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Aduce toti userii
     * @return-> UserDto
     */
    public List<UserDto> getAll(){


            List<Users> users = usersRepository.findAll();

            List<UserDto> dtos = new ArrayList<>();

            users.forEach(user ->dtos.add(toDto(user)));

            return dtos;
        }


    /**
     * Aduce user in functie de ID
     * @param id-> Id-ul efectiv al user-ului
     * @return  -> UserDto
     */
    public UserDto getUserById(Long id){

        Users user=usersRepository.findById(id).orElse(null);


        return toDto(user);

    }

    public void createPasswordResetTokenForUser(Users user, String token) {
        PasswordResetToken myToken = new PasswordResetToken(token, user);
        Date currentTime = new Date();
        Date expiryDate = new Date(currentTime.getTime() + 3000*1000);
        myToken.setExpiryDate(expiryDate);
        passwordResetToken.save(myToken);
    }

    /**
     * Se aduce user-ul care are numele dorit
     * @param name-> Numele efectiv al user-ului
     * @return UserDto
     */
    public UserDto getUserByName( String name){

        Users user=usersRepository.findByName(name);


        return toDto(user);

    }

    /**
     * Se aduce user-ul care are username-ul dorit
     * @param username -> username User
     * @return->UserDto
     */
    public UserDto getUserByUsername(String username){

        Users user=usersRepository.findByUsername(username);


        return toDto(user);

    }

    /**
     * Se aduce user-ul care are mail-ul dorit
     * @param email -> Mail user
     * @return UserDto
     */
    public UserDto getUserByEmail(String email){

        Users user=usersRepository.findByEmail(email);


        return toDto(user);

    }

    /**
     * Se aduce user-ul care are masina dorita
     * @param car -> Masina user
     * @return  List<UserDto>
     */
    public List<UserDto> getUserByCar(String car){

        List<Users> users = usersRepository.findAll();

        List<UserDto> dtos = new ArrayList<>();

       for(int i=0;i<users.size();i++){

           if(users.get(i).getCar().equals(car)){

               dtos.add(toDto(users.get(i)));

           }

       }

        return dtos;

    }

    /**
     * Se aduce user-ul care are rolul dorit
     * @param role-> rolul user-ului
     * @return->List<UserDto>
     */
    public List<UserDto> getUserByRole(String role){

        List<Users> users = usersRepository.findAll();

        List<UserDto> dtos = new ArrayList<>();

        for(int i=0;i<users.size();i++){

            if(users.get(i).getRole().equals(role)){

                dtos.add(toDto(users.get(i)));

            }

        }

        return dtos;

    }

    /**
     * Se aduce user-ul care adresa specificata
     * @param adress -> Adresa efectiva a user-ului
     * @return -> UserDto
     */

    public UserDto getUserByAdress(String adress){

        Users user=usersRepository.findByAdress(adress);


        return toDto(user);

    }

    /**
     * Modificarea unui User existent
     * @param username Cautare dupa username
     * @param userDto  Body type
     * @throws Exception-> Verificare > daca au fost modificate field-uri
     */
    public void updateUser(String username,UserDto userDto) throws Exception {

        boolean hasChanged = false;
        Users newUser = usersRepository.findByUsername(username);

        if (newUser == null) {
            throw new Exception("User with username " + userDto.getUsername() + " does not exist!");
        }

        if (userDto.getName() != null) {
            newUser.setName(userDto.getName());
            hasChanged = true;
        }

        if (userDto.getUsername() != null) {
            newUser.setUsername(userDto.getUsername());
            hasChanged = true;
        }

        if (userDto.getPassword() != null) {
            newUser.setPassword(userDto.getPassword());
            hasChanged = true;
        }

        if (userDto.getEmail() != null) {
            newUser.setEmail(userDto.getEmail());
            hasChanged = true;
        }

        if (userDto.getCar() != null) {
            newUser.setCar(userDto.getCar());
            hasChanged = true;
        }

        if (userDto.getRole() != null) {
            newUser.setRole(userDto.getRole());
            hasChanged = true;
        }

        if (userDto.getAdress() != null) {
            newUser.setAdress(userDto.getAdress());
            hasChanged = true;
        }

        if (userDto.getPhonenumber() != null) {
            newUser.setPhonenumber(userDto.getPhonenumber());
            hasChanged = true;
        }

        if (userDto.getCountry() != null) {
            newUser.setCountry(userDto.getCountry());
            hasChanged = true;
        }

        if (userDto.getState() != null) {
            newUser.setState(userDto.getState());
            hasChanged = true;
        }

        if (userDto.getEngine() != null) {
            newUser.setEngine(userDto.getEngine());
            hasChanged = true;
        }


        if (hasChanged) {
            usersRepository.save(newUser);
        } else {
            throw new Exception("No updates present!");
        }
    }

    /**
     * Stergerea tuturor utilizatorilor
     */
    public void deleteAll(){

        usersRepository.deleteAll();

    }

    /**
     * Stergere dupa username[ field unique ]
     * @param username-> Username-ul utilizatorului
     * @throws Exception-> Verificare body user
     */
    public void deleteByUsername(String username) throws Exception {
        Users user = usersRepository.findByUsername(username);
        if(user == null) {
            throw new Exception("Null User");
        }
        usersRepository.delete(user);

    }

    /**
     * Salvare user nou
     * @param userDto  Scheletul care este populat din frontend
     * @throws Exception-> Verificare body
     */
    public void save(UserDto userDto) throws Exception{

        if(userDto.checkEmptyField()){

            throw new Exception("Bad body");

        }
        String encodedPass = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPass);
        usersRepository.save(toUser(userDto));


    }


    /**
     * Transformarea entiatii in type-ul cerut de front-end
     * @param user  Entitatea in sine
     * @return  UserDto-> "scheletul" entitatii cu field-urile dorite
     */
    private UserDto toDto(Users user)
    {
        return new UserDto(user.getId(),user.getName(),user.getUsername(),user.getPassword(),user.getEmail(),user.getCar(), user.getRole(), user.getAdress(),user.getPhonenumber(),user.getCountry(),user.getCountry(),user.getEngine());
    }

    /**
     * Transformarea "scheletului" primit de la front-end in tipul necesar pentru backend respectiv DB
     * @param userDto -> informatia venita de la front-end
     * @return -> Users type
     */
    private Users toUser(UserDto userDto){

        return new Users(userDto.getName(), userDto.getUsername(), userDto.getPassword(), userDto.getEmail(),userDto.getCar(),userDto.getRole(),userDto.getAdress(),userDto.getPhonenumber(), userDto.getCountry(), userDto.getState(), userDto.getEngine());

    }


    public void updatePassword( String token, String password) throws Exception{
        PasswordResetToken entry=passwordResetService.findByToken(token);

        Calendar cal = Calendar.getInstance();
        if(entry.getExpiryDate().before(cal.getTime())) {
            throw new Exception("Token expired!");
        }
        else{
            Users currentUser=entry.getUser();
            String encodedPass = passwordEncoder.encode(password);
            currentUser.setPassword(encodedPass);
            usersRepository.save(currentUser);

        }


    }





}


