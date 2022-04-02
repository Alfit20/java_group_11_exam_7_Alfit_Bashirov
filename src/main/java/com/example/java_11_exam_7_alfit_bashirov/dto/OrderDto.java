package com.example.java_11_exam_7_alfit_bashirov.dto;

import com.example.java_11_exam_7_alfit_bashirov.entity.Customer;
import com.example.java_11_exam_7_alfit_bashirov.entity.Dish;
import com.example.java_11_exam_7_alfit_bashirov.entity.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;

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

    public static OrderDto toDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .customer(order.getCustomer())
                .orderedDish(order.getOrderedDish())
                .orderLate(order.getOrderLate())
                .build();
    }
}
