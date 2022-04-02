package com.example.java_11_exam_7_alfit_bashirov.controller;

import com.example.java_11_exam_7_alfit_bashirov.dto.DishDto;
import com.example.java_11_exam_7_alfit_bashirov.dto.InstitutionDto;
import com.example.java_11_exam_7_alfit_bashirov.entity.Customer;
import com.example.java_11_exam_7_alfit_bashirov.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        } catch (NullPointerException npe) {
            return new ResponseEntity<>("Чтобы сделать заказ нужно авторизоваться", HttpStatus.BAD_REQUEST);
        }

    }
}
