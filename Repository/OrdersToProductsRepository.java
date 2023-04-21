package com.example.demojpa3.Repository;

import com.example.demojpa3.Entity.OrdersToProducts;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository-> JPA -> cu ajutorul interfetei se stocheaza metode prestabilite pe care ulterior le folsim in layer-ul de Service
 */
public interface OrdersToProductsRepository extends JpaRepository<OrdersToProducts,Long> {
}
