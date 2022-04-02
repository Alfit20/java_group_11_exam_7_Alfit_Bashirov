package com.example.java_11_exam_7_alfit_bashirov.service;

import com.example.java_11_exam_7_alfit_bashirov.dto.DishDto;
import com.example.java_11_exam_7_alfit_bashirov.dto.InstitutionDto;
import com.example.java_11_exam_7_alfit_bashirov.entity.Customer;
import com.example.java_11_exam_7_alfit_bashirov.entity.Dish;
import com.example.java_11_exam_7_alfit_bashirov.entity.Order;
import com.example.java_11_exam_7_alfit_bashirov.repository.CustomerRepository;
import com.example.java_11_exam_7_alfit_bashirov.repository.DishRepository;
import com.example.java_11_exam_7_alfit_bashirov.repository.InstitutionRepository;
import com.example.java_11_exam_7_alfit_bashirov.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final InstitutionRepository institutionRepository;
    private final CustomerRepository customerRepository;
    private final DishRepository dishRepository;


    public void order(DishDto dto, Customer customer) {
       var id = dishRepository.findById(dto.getId()).get();
        var customerEmail = customerRepository.findCustomerByEmail(customer.getEmail());
        orderRepository.save(Order.builder()
                .customer(customerEmail)
                .orderedDish(id)
                .orderLate(LocalDate.now())
                .build());

    }
}
