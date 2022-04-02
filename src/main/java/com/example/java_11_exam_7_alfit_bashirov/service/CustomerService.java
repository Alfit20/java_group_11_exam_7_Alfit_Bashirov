package com.example.java_11_exam_7_alfit_bashirov.service;

import com.example.java_11_exam_7_alfit_bashirov.dto.OrderDto;
import com.example.java_11_exam_7_alfit_bashirov.entity.Customer;
import com.example.java_11_exam_7_alfit_bashirov.entity.Order;
import com.example.java_11_exam_7_alfit_bashirov.repository.CustomerRepository;
import com.example.java_11_exam_7_alfit_bashirov.repository.DishRepository;
import com.example.java_11_exam_7_alfit_bashirov.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public List<OrderDto> orderListCustomer(Customer customer) {
        var c = orderRepository.findOrderByCustomerEmail(customer.getEmail());
        List<OrderDto> orderDtos = new ArrayList<>();
        c.stream().forEach(a -> orderDtos.add(OrderDto.toDto(a)));
        return orderDtos;
    }
}
