package com.test_6.Order.repository;

import com.test_6.Order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT * FROM order WHERE id = ?1", nativeQuery = true)
    Order getOrderById(Integer id);
    //Order getOrderById(@Param("id") Integer id);
}