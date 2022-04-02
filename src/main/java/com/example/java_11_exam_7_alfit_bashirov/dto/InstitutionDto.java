package com.example.java_11_exam_7_alfit_bashirov.dto;

import com.example.java_11_exam_7_alfit_bashirov.entity.Institution;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstitutionDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;


    public static InstitutionDto from(Institution institution) {
        return builder()
                .id(institution.getId())
                .name(institution.getName())
                .description(institution.getDescription())
                .build();
    }
}
