package com.example.java_11_exam_7_alfit_bashirov.repository;

import com.example.java_11_exam_7_alfit_bashirov.entity.Dish;
import com.example.java_11_exam_7_alfit_bashirov.entity.Institution;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {
    List<Dish> findDishByInstitution(Institution id, Pageable pageable);
}
