package com.example.demojpa3.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.demojpa3.Dto.OrdersDto;
import com.example.demojpa3.Entity.Orders;
import com.example.demojpa3.Entity.Users;
import com.example.demojpa3.Repository.OrdersRepository;
import com.example.demojpa3.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
public class OrdersService  {

    /**
     * Auto Instantiere a unui parametru de tip OrdersRepository
     * -> Astfel se garanteaza accesul la metodele predefinite stocate in interfata cu ajutorul JpaRepository
     */
    @Autowired
    OrdersRepository ordersRepository;

    /**
     * Auto Instantiere a unui parametru de tip OrdersRepository
     * -> Astfel se garanteaza accesul la metodele predefinite stocate in interfata cu ajutorul JpaRepository
     */
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    EntityManager entityManager;

    /**
     * Service-> Se cauta user-ul dupa ID
     * @param id Id-ul userului
     * @return  OrdersDto
     */
    public OrdersDto findById( Long id){

        Orders order=ordersRepository.findById(id).orElse(null);


        return toDto(order);

    }

    /**
     * Service-> Gaseste toate entitatile de tip Order
     * @return Lista cu comenzile (Orders)
     */
    public List<OrdersDto> findAll(){

        List<Orders> orders = ordersRepository.findAll();

        List<OrdersDto> dtos = new ArrayList<>();

        orders.forEach(order ->dtos.add(toDto(order)));

        return dtos;

    }

    /**
     * Sterge toate comenzile( Orders )
     */
    public void deleteAll(){

        ordersRepository.deleteAll();

    }

    /**
     * Stergere comenzi in functie de Id
     * @param id -> Id-ul comenzii
     */
    public void deleteById(Long id)
    {

        ordersRepository.deleteById(id);

    }

    public List<OrdersDto> getOrderByUserId(Long id)
    {
        Query curry=entityManager.createQuery("SELECT x FROM Users x WHERE x.id= :userId");

        curry.setParameter("userId", id);

        Users user=(Users)curry.getSingleResult();



        String comand="SELECT x FROM Orders x WHERE x.refUser = :refUser";



        Query query=entityManager.createQuery(comand);

        query.setParameter("refUser", user);

        List<Orders> orders= query.getResultList();

        List<OrdersDto> ordersDtos=new ArrayList<>();


        for(int i=0;i< orders.size();i++) {

        ordersDtos.add(toDto(orders.get(i)));

        }

        return ordersDtos;
    }



    /**
     * Salvarea comenzilor
     * @param ordersDto -> Scheletul care trebuie respectat
     * @throws Exception -> In caz ca forma nu este conforma cu cea ceruta-> "Bad body"
     */
    public void saveOrder(OrdersDto ordersDto) throws Exception{

        Users user=usersRepository.findById(ordersDto.getUserId()).orElse(null);

        if(user==null){

            throw new Exception("Null user");

        }


        if(ordersDto.checkEmptyField()){

            throw new Exception("Bad body");

        }

        ordersRepository.save(toOrder(user,ordersDto));

    }

    /**
     * Modificarea field-urilor de tip Order
     * @param id -> Se specifica id-ul orderului
     * @param orderDto  -> Se specifica entitatea si, prin ea totodata structura dorita
     * @throws Exception -> Se verifica modificari aduse entitatii -> Daca nu a fost modificat niciun field -> Exceptie
     */
    public void updateOrder(Long id, OrdersDto orderDto) throws Exception {

        boolean hasChanged = false;
        Orders newOrder = ordersRepository.findById(id).orElse(null);

        if (newOrder == null) {
            throw new Exception("User with id " + id + " does not exist!");
        }

        if (orderDto.getId() != 0) {
            newOrder.setId(orderDto.getId());
            hasChanged = true;
        }

        if (orderDto.getPriceTotal() != 0) {
            newOrder.setPriceTotal(orderDto.getPriceTotal());
            hasChanged = true;
        }

        if (orderDto.getDetails() != null) {
            newOrder.setDetails(orderDto.getDetails());
            hasChanged = true;
        }



        if (hasChanged) {
            ordersRepository.save(newOrder);
        } else {
            throw new Exception("No updates present!");
        }
    }

    /**
     * Transformarea entiatii in type-ul cerut de front-end
     * @param orders  Entitatea in sine
     * @return  OrdersDto-> "scheletul" entitatii cu field-urile dorite
     */
    private OrdersDto toDto(Orders orders)
    {
        return new OrdersDto(orders.getRefUser().getId(), orders.getId(), orders.getPriceTotal(), orders.getDetails());
    }

    /**
     * Transformarea "scheletului" primit de la front-end in tipul necesar pentru backend respectiv DB
     * @param user -> body-ul dorit
     * @param ordersDto -> informatia venita de la front-end
     * @return -> Order type
     */
    private Orders toOrder(Users user, OrdersDto ordersDto){



        return new Orders(ordersDto.getId(), ordersDto.getPriceTotal(), ordersDto.getDetails(),user);

    }

//    public List<OrdersDto> getOrderByUserUsername(String username){
//
//        List<Orders> orders=ordersRepository.findByRefUserUsername(username);
//        List<OrdersDto> dtos=new ArrayList<>();
//
//        orders.forEach(order -> {
//                dtos.add(toDto(order));
//        });
//
//        return dtos;
//
//    }

}


