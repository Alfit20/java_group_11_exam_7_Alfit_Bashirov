package com.example.java_11_exam_7_alfit_bashirov.controller;

import com.example.java_11_exam_7_alfit_bashirov.dto.CustomerDto;
import com.example.java_11_exam_7_alfit_bashirov.service.AuthUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final AuthUserDetailsService service;


    @PostMapping
    public ResponseEntity<String> userRegistration(@RequestBody CustomerDto customerDto) {
        try {
            service.registration(customerDto);
            return new ResponseEntity<>("Успешная регистрация", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Такая почта уже существует", HttpStatus.OK);
        }

    }
}
