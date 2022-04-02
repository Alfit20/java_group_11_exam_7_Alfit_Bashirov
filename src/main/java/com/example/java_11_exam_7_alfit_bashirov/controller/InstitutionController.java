package com.example.java_11_exam_7_alfit_bashirov.controller;


import com.example.java_11_exam_7_alfit_bashirov.dto.InstitutionDto;
import com.example.java_11_exam_7_alfit_bashirov.service.InstitutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/institution")
public class InstitutionController {
    private final InstitutionService institutionService;

    @GetMapping
    public List<InstitutionDto> getAll(Pageable pageable) {
        return institutionService.getInstitution(pageable);
    }

//    @GetMapping("/dishes")
//    public ResponseEntity<String> getDished(Long id, Pageable pageable) {
//        institutionService.dishesByEstablishment(id, pageable);
//        return ResponseEntity.ok().build();
//    }
}
