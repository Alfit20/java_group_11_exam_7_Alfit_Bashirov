package com.example.java_11_exam_7_alfit_bashirov.controller;

import com.example.java_11_exam_7_alfit_bashirov.dto.DishDto;
import com.example.java_11_exam_7_alfit_bashirov.dto.InstitutionDto;
import com.example.java_11_exam_7_alfit_bashirov.entity.Customer;
import com.example.java_11_exam_7_alfit_bashirov.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> addOrder(@RequestBody DishDto dto, Authentication authentication) {
        try {
            Customer customer = (Customer) authentication.getPrincipal();
            orderService.order(dto, customer);
            return new ResponseEntity<>("Добавлен заказ", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Такого блюда нет", HttpStatus.BAD_REQUEST);
        }
    }


}
