package com.example.java_11_exam_7_alfit_bashirov.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dish")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "type_dish")
    private String typeDish;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

}
