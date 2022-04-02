package com.example.java_11_exam_7_alfit_bashirov.service;

import com.example.java_11_exam_7_alfit_bashirov.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

}
