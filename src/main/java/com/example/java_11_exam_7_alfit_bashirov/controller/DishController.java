package com.example.java_11_exam_7_alfit_bashirov.controller;

import com.example.java_11_exam_7_alfit_bashirov.dto.DishDto;
import com.example.java_11_exam_7_alfit_bashirov.dto.InstitutionDto;
import com.example.java_11_exam_7_alfit_bashirov.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/dishes")
public class DishController {
    private final DishService dishService;

    @GetMapping
    public List<DishDto> getDished(@RequestBody InstitutionDto id, Pageable pageable) {
        try {
            return dishService.dishesByEstablishment(id, pageable);
        } catch (NoSuchElementException e) {
            return null;
        }

    }
}
