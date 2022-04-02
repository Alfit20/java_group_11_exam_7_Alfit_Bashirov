package com.example.java_11_exam_7_alfit_bashirov.dto;

import com.example.java_11_exam_7_alfit_bashirov.entity.Customer;
import com.example.java_11_exam_7_alfit_bashirov.entity.Dish;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    @JsonProperty("customer_id")
    private Customer customer;
    @JsonProperty("order_id")
    private Dish orderedDish;
    @JsonProperty("order_late")
    private LocalDate orderLate;
}
