package com.example.demojpa3.Controller;

import com.example.demojpa3.Dto.UserDto;
import com.example.demojpa3.Entity.Users;
import com.example.demojpa3.Repository.UsersRepository;
import com.example.demojpa3.Service.PasswordResetService;
import com.example.demojpa3.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Layer-ul de controller se ocupa de declararea endpoint-urilor cu ajutorul technologiei JPA, endpoint-uri care ne sunt de ajutor in legarea frontend-ului cu backend-ul
 * Acest Layer se ocupa in special de utlizatori [ responsabil pentru entitatea Users ]
 */

@RestController
@RequestMapping(path="/users")
@CrossOrigin("*")
public class UsersController {

    /**
     * Service Layer -> responsabil pentru accesarea functionalitatilor creeate in Service
     */
    @Autowired
    UsersService usersService;


    @Autowired
    PasswordResetService passwordResetService;

    @Autowired
    UsersRepository usersRepo;




    /**
     * Se aduc toti utilizatorii
     *
     * @return -> Lista cu toti utilizatorii
     */
    @GetMapping(path = "/getAll")
    public List<UserDto> findAll() {

        return usersService.getAll();

    }


    /**
     * Se aduce utilizatorul cu id-ul dorit
     *
     * @param id Id-ul user-ului cautat
     * @return -> UserDto
     */
    @GetMapping(path = "/getById/{id}")
    public UserDto getById(@PathVariable("id") long id) {


        return usersService.getUserById(id);

    }


    /**
     * Se aduce utilizatorul cu numele dorit
     *
     * @param name-> Numele utilizatorului
     * @return -> UserDto
     */
    @GetMapping(path = "/getByName/{name}")
    public UserDto getByName(@PathVariable("name") String name) {


        return usersService.getUserByName(name);

    }


    /**
     * Se aduce user-ul dupa username
     *
     * @param username -> Username-ul utilizatorului
     * @return -> UserDto
     */
    @GetMapping(path = "/getByUsername/{username}")
    public UserDto getUserByUsername(@PathVariable("username") String username) {

        return usersService.getUserByUsername(username);

    }


    /**
     * Se aduce user-ul in fucntie de e-mail
     *
     * @param email -> E-mail-ul utilizatorului
     * @return UserDto
     */
    @GetMapping(path = "/getByEmail/{email}")
    public UserDto getUserByEmail(@PathVariable("email") String email) {

        return usersService.getUserByEmail(email);

    }


    /**
     * Se aduc utilizatori care au masina selectata
     *
     * @param car-> Modelul de masina dupa care se face cautarea
     * @return -> Lista
     */
    @GetMapping(path = "/getByCar/{car}")
    public List<UserDto> getUserByCar(@PathVariable("car") String car) {

        return usersService.getUserByCar(car);

    }


    /**
     * Se aduc utilizatori care au rolul selectat
     *
     * @param role-> Rolul dupa care se face cautarea
     * @return -> Lista
     */
    @GetMapping(path = "/getByRole/{role}")
    public List<UserDto> getUserByRole(@PathVariable("role") String role) {

        return usersService.getUserByRole(role);

    }


    /**
     * Se aduc utilizatori care au adressa selectata
     *
     * @param adress-> Adresa dupa care se face cautarea
     * @return -> Lista
     */
    @GetMapping(path = "/getByAdress/adress")
    public UserDto getUserByAdress(@PathVariable("adress") String adress) {

        return usersService.getUserByAdress(adress);

    }


    /**
     * Modificarea unui user curent in functie de username[ field unique ]
     *
     * @param username->[unique] Username-ul utilizatorului
     * @param userDto->          Req. Body
     * @throws Exception ->Service Layer
     */
    @PutMapping(path = "/update/{username}")
    public void updateUser(@PathVariable String username, @RequestBody UserDto userDto) throws Exception {

        usersService.updateUser(username, userDto);
    }


    /**
     * Stergerea tuturor utilizatorilor
     */
    @DeleteMapping(path = "/deleteAll")
    public void deleteAll() {

        usersService.deleteAll();


    }


    /**
     * Stergere dupa username[ field unique ]
     *
     * @param username-> Username-ul utilizatorului
     * @return -> Exceptie || Mesaj ca a functionat
     */
    @DeleteMapping(path = "/delete/byUsername/{username}")
    public String deleteById(@PathVariable("username") String username) {

        try {
            usersService.deleteByUsername(username);
            return "Deleted!";
        } catch (Exception e) {
            return e.getMessage();
        }


    }


    /**
     * Salvarea unei noi instante User
     *
     * @param userDto Req. Body
     */
    @PostMapping(path = "/save")
    public void save(@RequestBody UserDto userDto) {

        try {

            usersService.save(userDto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



    @GetMapping("/info")
    public Users getUserDetails() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return usersRepo.findByUsername(username);
    }

    @PutMapping("/resetPassword")
    public void updatePassword(@RequestParam("token") String token,@RequestParam("password") String password) throws Exception{

    usersService.updatePassword(token,password);

    }



}