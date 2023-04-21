package com.example.demojpa3.Service;


import com.example.demojpa3.Dto.ProductsDto;
import com.example.demojpa3.Dto.UserDto;
import com.example.demojpa3.Entity.Products;
import com.example.demojpa3.Entity.Users;
import com.example.demojpa3.Repository.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductsService {

    /**
     * Auto Instantiere a unui parametru de tip ProductsRepository
     * -> Astfel se garanteaza accesul la metodele predefinite de catre JPA, stocate in interfata cu ajutorul JpaRepository
     */
    @Autowired
    ProductsRepository productsRepository;

    /**
     * Se aduc toate entitatile de tip Products
     * @return  Lista cu toate entitatile de tip Products
     */
    public List<ProductsDto> getAllProducts(){

        List<Products> products = productsRepository.findAll();

        List<ProductsDto> dtos = new ArrayList<>();

        products.forEach(user ->dtos.add(toDto(user)));

        return dtos;

    }


    /**
     * Se cauta produse pe baza id-ului acestora
     * @param id    -> Id-ul efectiv al produsului
     * @return  -> Pe baza id-ului se returneaza produsul cautat
     */
    public ProductsDto getProductsById( long id ){

        Products products=productsRepository.findById(id).orElse(null);

        return toDto(products);

    }


    /**
     * Cautare pe baza numelui
     * @param name-> Numele produsului
     * @return -> Produsul cu numele cautat
     */
    public ProductsDto getProductsByName( String name ){

        Products products = productsRepository.findByName(name);


        return toDto(products);

    }


    /**
     * Modificarea instantei de tip Product
     * @param id  -> Cautarea entiatii pe baza id
     * @param productDto -> "Scheletul" transmis de front-end
     * @throws Exception -> Detectarea eficienta a posibilelor erori
     */
    public void updateProduct(Long id,ProductsDto productDto) throws Exception {

        boolean hasChanged = false;
        Products newProduct = productsRepository.findById(id).orElse(null);

        if (newProduct == null) {
            throw new Exception("User with id " + id + " does not exist!");
        }

        if (productDto.getName() != null) {
            newProduct.setName(productDto.getName());
            hasChanged = true;
        }

        if (productDto.getDescription() != null) {
            newProduct.setDescription(productDto.getDescription());
            hasChanged = true;
        }

        if (productDto.getStock() != null) {
            newProduct.setStock(productDto.getStock());
            hasChanged = true;
        }

        if (productDto.getPrice() != 0) {
            newProduct.setPrice(productDto.getPrice());
            hasChanged = true;
        }


        if (hasChanged) {
            productsRepository.save(newProduct);
        } else {
            throw new Exception("No updates present!");
        }
    }

    /**
     * Salvarea in DB a entitatii de tip produs
     * @param productDto "Scheletul" entitatii
     * @throws Exception ->Detectarea eficienta a posibilelor erori
     */
    public void saveProduct(ProductsDto productDto) throws Exception{

        log.info("Name: {}, Desc: {}, Price: {}, Stock: {}, Logo:", productDto.getName(), productDto.getDescription(), productDto.getPrice(), productDto.getStock());
        if(productDto.checkEmptyField()){

            throw new Exception("Bad body");

        }

        productsRepository.save(toProduct(productDto));

    }

    /**
     * Stergerea tuturor produselor
     */
    public void deleteAll(){

        productsRepository.deleteAll();

    }

    /**
     * Stergere produs in functie de id
     * @param id -> Id-ul produsului
     */
    public void deleteById(Long id){

        productsRepository.deleteById(id);

    }

    /**
     * Transformarea entiatii in type-ul cerut de front-end
     * @param products  Entitatea in sine
     * @return  OrdersDto-> "scheletul" entitatii cu field-urile dorite
     */
    private ProductsDto toDto(Products products)
    {
        return new ProductsDto(products.getId(),products.getName(), products.getDescription(), products.getStock(), products.getPrice(), products.getLogo());
    }


    /**
     * Transformarea "scheletului" primit de la front-end in tipul necesar pentru backend respectiv DB
     * @param productDto -> informatia venita de la front-end
     * @return -> Order type
     */
    private Products toProduct(ProductsDto productDto){

        return new Products(productDto.getName(), productDto.getDescription(), productDto.getStock(), productDto.getPrice(), productDto.getLogo());

    }
}
