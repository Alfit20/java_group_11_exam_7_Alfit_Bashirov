package com.example.java_11_exam_7_alfit_bashirov.service;

import com.example.java_11_exam_7_alfit_bashirov.dto.InstitutionDto;
import com.example.java_11_exam_7_alfit_bashirov.repository.InstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstitutionService {
   private final InstitutionRepository institutionRepository;

    public List<InstitutionDto> getInstitution(Pageable pageable) {
        List<InstitutionDto> institutionDtos = new ArrayList<>();
        var institution = institutionRepository.findAll(pageable);
        institution.stream().forEach(a -> institutionDtos.add(InstitutionDto.from(a)));
        return institutionDtos;
    }
}
