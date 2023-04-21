package com.example.demojpa3.Controller;


import com.example.demojpa3.Dto.OrdersToProductsDto;
import com.example.demojpa3.Service.OrdersToProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/link")
@CrossOrigin("*")
public class OrdersToProductController {

    @Autowired
    OrdersToProductsService ordersToProductsService;

    @GetMapping(path="/all")
    public List<OrdersToProductsDto> getAll(){

        return ordersToProductsService.getAll();

    }

    @DeleteMapping(path="/deleteAll")
    public void deleteAll (){

        ordersToProductsService.deleteAll();

    }

    @PostMapping(path="/update")
    public void updateLink(@PathVariable Long quantity, @RequestBody OrdersToProductsDto ordersToProductsDto){

        ordersToProductsService.updateQuatntity(quantity,ordersToProductsDto);

    }

}
