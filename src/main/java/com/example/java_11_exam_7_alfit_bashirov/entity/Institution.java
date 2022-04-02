package com.example.java_11_exam_7_alfit_bashirov.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "institution_table")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

}
