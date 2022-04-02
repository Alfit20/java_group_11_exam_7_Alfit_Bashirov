package com.example.java_11_exam_7_alfit_bashirov.service;

import com.example.java_11_exam_7_alfit_bashirov.dto.DishDto;
import com.example.java_11_exam_7_alfit_bashirov.dto.InstitutionDto;
import com.example.java_11_exam_7_alfit_bashirov.entity.Dish;
import com.example.java_11_exam_7_alfit_bashirov.repository.DishRepository;
import com.example.java_11_exam_7_alfit_bashirov.repository.InstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;
    private final InstitutionRepository institutionRepository;

    public List<DishDto> dishesByEstablishment(InstitutionDto id, Pageable pageable) {
        var a = institutionRepository.findById(id.getId()).get();
        List <Dish> dish = dishRepository.findDishByInstitution(a, pageable);
        List<DishDto> listDishes = new ArrayList<>();
        dish.forEach(c -> listDishes.add(DishDto.from(c)));
        return listDishes;
    }
}
