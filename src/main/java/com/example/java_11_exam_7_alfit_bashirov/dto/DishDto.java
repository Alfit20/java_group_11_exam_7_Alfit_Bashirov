package com.example.java_11_exam_7_alfit_bashirov.dto;

import com.example.java_11_exam_7_alfit_bashirov.entity.Dish;
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
public class DishDto {
    private Long id;
    private String name;
    @JsonProperty("type_dish")
    private String typeDish;
    private Integer price;
    @JsonProperty("institution_id")
    private Institution institution;

    public static DishDto from(Dish dish) {
        return builder()
                .id(dish.getId())
                .name(dish.getName())
                .typeDish(dish.getTypeDish())
                .price(dish.getPrice())
                .institution(dish.getInstitution())
                .build();
    }
}
