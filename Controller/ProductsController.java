package com.example.demojpa3.Controller;

import com.example.demojpa3.Dto.ProductsDto;
import com.example.demojpa3.Dto.UserDto;
import com.example.demojpa3.Entity.Products;
import com.example.demojpa3.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Layer-ul de controller se ocupa de declararea endpoint-urilor cu ajutorul technologiei JPA, endpoint-uri care ne sunt de ajutor in legarea frontend-ului cu backend-ul
 * Acest Layer se ocupa in special de produse [ responsabil pentru entitatea Products ]
 */

@RestController
@RequestMapping(path="/products")
@CrossOrigin("*")
public class ProductsController {

    /**
     *  Service Layer -> responsabil pentru accesarea functionalitatilor creeate in Service
     */
    @Autowired
    ProductsService productsService;

    /**
     * Get- Aduce toate produsele
     * @return  Lista cu toate produsele
     */
    @GetMapping(path="/getAll")
    public List<ProductsDto> getAll(){

        return productsService.getAllProducts();

    }

    /**
     * GET- Se aduce produsul cu id-ul specificat
     * @param id->Id-ul produsului
     * @return ->ProductsDto
     */
    @GetMapping(path="/getById/{id}")
    public ProductsDto getById(@PathVariable("id") long id){

        return productsService.getProductsById(id);

    }

    /**
     * GET- In functie de numele produsului
     * @param name-> Numele produsului
     * @return -> Dto
     */
    @GetMapping(path="/getByName/{name}")
    public ProductsDto getByName(@PathVariable("name") String name){

        return productsService.getProductsByName(name);

    }

    /**
     * Modificarea unui produs existent
     * @param id->Id-ul produsului respectiv
     * @param productDto->Req. Body
     * @throws Exception->Service Layer
     */
    @PutMapping(path="/update/{id}")
    public void updateProduct(@PathVariable("id") Long id,@RequestBody ProductsDto productDto) throws Exception {
        productsService.updateProduct(id,productDto);
    }

    /**
     * Salvarea produsului
     * @param productsDto->Req. Body
     */
    @PostMapping(path="/save")
    public void saveProduct(@RequestBody ProductsDto productsDto){

        try {

            productsService.saveProduct(productsDto);
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    /**
     * Stergerea tuturor produselor
     */
    @DeleteMapping(path="/deleteAll")
    public void deleteAll(){

        productsService.deleteAll();

    }

    /**
     * Stergere in functie de id
     * @param id-> Id-ul efectiv al produsului
     */
    @DeleteMapping(path="/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){

        productsService.deleteById(id);

    }






}

