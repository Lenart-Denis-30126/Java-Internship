package com.example.demojpa3.Controller;


import com.example.demojpa3.Dto.OrdersDto;
import com.example.demojpa3.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Layer-ul de controller se ocupa de declararea endpoint-urilor cu ajutorul technologiei JPA, endpoint-uri care ne sunt de ajutor in legarea frontend-ului cu backend-ul
 * Acest Layer se ocupa in special de comenzi [ responsabil pentru entitatea Orders ]
 */

@RestController
@RequestMapping(path="/orders")
@CrossOrigin("*")
public class OrdersController {

    /**
     *  Service Layer -> responsabil pentru accesarea functionalitatilor creeate in Service
     */
    @Autowired
    OrdersService ordersService;


    /**
     * GET Order by ID
     * @param id-> Transmitem id-ul comenzii
     * @return Se returneaza entitatea Orders cu Id ul specificat
     */
    @GetMapping(path = "/get/getById/{id}")
    public OrdersDto getById(@PathVariable("id") Long id){

        return ordersService.findById(id);
    }


    @GetMapping(path = "/get/getByUserId/{id}")
    public List<OrdersDto> getByUserId(@PathVariable("id") Long id){

        return ordersService.getOrderByUserId(id);
    }

    /**
     * GET- Cautarea tuturor comenzilor
     * @return  Lista tuturor comenzilor
     */
    @GetMapping(path = "/getOrders/All")
    public List<OrdersDto> findAll(){

        return ordersService.findAll();

    }


    /**
     * Stergerea tuturor comenzilor
     */

       @DeleteMapping(path = "/delete/deleteAll")
    public void deleteAll(){

        ordersService.deleteAll();

    }

    /**
     * Stergere comanda in functie de id
     * @param id-> Id ul comenzii
     */
    @DeleteMapping(path = "/deleteById/{id}")
    public void deleteById(@PathVariable("id")Long id){


        ordersService.deleteById(id);

    }

    /**
     * Salvare comanda noua
     * @param orderDto-> Informatia este primita din frontend deci request body este de tip Dto
     */
    @PostMapping (path="/save")
    public void saveOrder(@RequestBody OrdersDto orderDto){


        try {

            ordersService.saveOrder(orderDto);
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Modificarea unei comenzi existente in functie de id
     * @param id-> Id-ul comenzii
     * @param orderDto-> Request Body: OrdersDto
     * @throws Exception-> Service Layer
     */
    @PutMapping(path="/update/{id}")
    public void updateOrder(@PathVariable("id") Long id,@RequestBody OrdersDto orderDto) throws Exception {

        ordersService.updateOrder(id,orderDto);

    }

//    @GetMapping(path="/getByUserUsername/{username}")
//    public List<OrdersDto> getByUserUsername(@PathVariable("username") String username){
//
//        return ordersService.getOrderByUserUsername(username);
//
//    }




}

