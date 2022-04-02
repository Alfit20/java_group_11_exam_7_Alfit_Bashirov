package com.example.java_11_exam_7_alfit_bashirov.repository;

import com.example.java_11_exam_7_alfit_bashirov.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findOrderByCustomerEmail(String email);
}
