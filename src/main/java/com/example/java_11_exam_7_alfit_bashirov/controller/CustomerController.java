package com.example.java_11_exam_7_alfit_bashirov.controller;

import com.example.java_11_exam_7_alfit_bashirov.dto.OrderDto;
import com.example.java_11_exam_7_alfit_bashirov.entity.Customer;
import com.example.java_11_exam_7_alfit_bashirov.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<OrderDto> getOrdersCustomer(Authentication authentication) {
        try {
            Customer customer = (Customer) authentication.getPrincipal();
            return customerService.orderListCustomer(customer);
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
