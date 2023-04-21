package com.example.demojpa3.Repository;

import com.example.demojpa3.Dto.RegisterCredentialsDto;
import com.example.demojpa3.Entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository-> JPA -> cu ajutorul interfetei se stocheaza metode prestabilite pe care ulterior le folsim in layer-ul de Service
 */
public interface UsersRepository extends JpaRepository<Users,Long> {

    /**
     * Users-> Cauta utilizatorul dupa nume
     * @param name -> Numele utilizatorului
     * @return  -> Entitate de tip User
     */
    Users findByName(String name);

    /**
     * Users-> Cauta utilizatorul dupa username [ field unique in DB ]
     * @param username -> Username-ul utilizatorului
     * @return -> Users Type
     */
    Users findByUsername(String username);

    /**
     * Users-> Cauta utilizatorul dupa email
     * @param email -> Email-ul utilizatorului
     * @return -> Users Type
     */
    Users findByEmail(String email);

    /**
     * Users-> Cauta utilizatorul dupa masina
     * @param car   -> Masina utilizatorului
     * @return -> Lista de useri cu masina respectiva
     */
    List<Users>findByCar(String car);

    /**
     * Users-> Cauta utilizatorul dupa rolul acestuia
     * @param role -> ROLE
     * @return -> Lista cu utilizatorii care au respectivul rol
     */


    List<Users>findByRole(String role);

    /**
     * Users-> Cauta utilizatorul dupa adresa acestuia
     * @param adress Adresa efectiva a utilizatorului
     * @return  User Type
     */
    Users findByAdress(String adress);

    /**
     * Users -> Stergere dupa username
     * @param username  -> Username-ul efectiv
     */
    void deleteByUsername(String username);



}


