package com.example.java_11_exam_7_alfit_bashirov.repository;

import com.example.java_11_exam_7_alfit_bashirov.entity.Institution;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutionRepository extends CrudRepository<Institution, Long> {
    List<Institution> findAll(Pageable pageable);

//    Institution findInstitutionById(Long id, Pageable pageable);
}
