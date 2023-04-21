package com.example.demojpa3.Repository;

import com.example.demojpa3.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository-> JPA -> cu ajutorul interfetei se stocheaza metode prestabilite pe care ulterior le folsim in layer-ul de Service
 */
public interface ProductsRepository extends JpaRepository<Products,Long> {
    /**
     * Se "anunta" metoda, respectiv paramterii si field-ul la care face referire, si se noteaza intuitiv cu findBy[Nume-Field-Entitate]( Tip [field-entitate] )
     * @param name - se paseaza numele, dupa care functia este responsabila sa gaseasca produsul dupa numele acestuia
     * @return -> Entitatea( in cazul de fata o entitate de tip Products )
     */
    Products findByName(String name);

}
