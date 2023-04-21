package com.example.demojpa3.Service;




import com.example.demojpa3.Dto.OrdersDto;
import com.example.demojpa3.Dto.OrdersToProductsDto;
import com.example.demojpa3.Dto.UserDto;
import com.example.demojpa3.Entity.Orders;
import com.example.demojpa3.Entity.OrdersToProducts;
import com.example.demojpa3.Entity.Users;
import com.example.demojpa3.Repository.OrdersToProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersToProductsService{

    @Autowired
    OrdersToProductsRepository ordersToProductsRepository;


    public List<OrdersToProductsDto> getAll(){

        List<OrdersToProducts> link = ordersToProductsRepository.findAll();

        List<OrdersToProductsDto> dtos = new ArrayList<>();

        link.forEach(user ->dtos.add(toDto(user)));

        return dtos;

    }

    public void deleteAll(){

        ordersToProductsRepository.deleteAll();

    }

    public void updateQuatntity(Long quantity, OrdersToProductsDto order)  {


        if (order.getQuantity() != 0) {

            order.setQuantity(quantity);

        }


    }

    private OrdersToProductsDto toDto(OrdersToProducts ordersToProducts)
    {
        return new OrdersToProductsDto(ordersToProducts.getId(), ordersToProducts.getQuantity());
    }

    private OrdersToProducts toLink(OrdersToProductsDto ordersToProductsDto){

        return new OrdersToProducts(ordersToProductsDto.getId(), ordersToProductsDto.getQuantity());

    }

}

