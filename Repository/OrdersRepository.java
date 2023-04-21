package com.example.demojpa3.Repository;

import com.example.demojpa3.Dto.OrdersDto;
import com.example.demojpa3.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository-> JPA -> cu ajutorul interfetei se stocheaza metode prestabilite pe care ulterior le folsim in layer-ul de Service
 */
public interface OrdersRepository extends JpaRepository<Orders,Long> {


}
