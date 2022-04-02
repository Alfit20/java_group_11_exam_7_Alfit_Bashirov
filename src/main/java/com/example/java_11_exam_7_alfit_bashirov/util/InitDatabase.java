package com.example.java_11_exam_7_alfit_bashirov.util;

import com.example.java_11_exam_7_alfit_bashirov.dto.GenerateData;
import com.example.java_11_exam_7_alfit_bashirov.entity.Customer;
import com.example.java_11_exam_7_alfit_bashirov.entity.Dish;
import com.example.java_11_exam_7_alfit_bashirov.entity.Institution;
import com.example.java_11_exam_7_alfit_bashirov.entity.Order;
import com.example.java_11_exam_7_alfit_bashirov.repository.CustomerRepository;
import com.example.java_11_exam_7_alfit_bashirov.repository.DishRepository;
import com.example.java_11_exam_7_alfit_bashirov.repository.InstitutionRepository;
import com.example.java_11_exam_7_alfit_bashirov.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Configuration
@RequiredArgsConstructor
public class InitDatabase {
    private final PasswordEncoder encoder;

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository, DishRepository dishRepository,
                           InstitutionRepository institutionRepository, OrderRepository orderRepository) {
        return (args) -> {
            orderRepository.deleteAll();
            dishRepository.deleteAll();
            institutionRepository.deleteAll();
            customerRepository.deleteAll();


            var customer1 = customerRepository.save(Customer.builder()
                    .name(GenerateData.randomPersonName())
                    .email("anton.a@gmail.com")
                    .password(encoder.encode("qwe"))
                    .build());
            var customer2 = customerRepository.save(Customer.builder()
                    .name(GenerateData.randomPersonName())
                    .email("pavel.p@gmail.com")
                    .password(encoder.encode("asd"))
                    .build());
            var customer3 = customerRepository.save(Customer.builder()
                    .name(GenerateData.randomPersonName())
                    .email("sergey.s@gmail.com")
                    .password(encoder.encode("zxc"))
                    .build());
            var ininstitution1 = institutionRepository.save(Institution.builder()
                    .description(GenerateData.randomPlace().getDescription())
                    .name(GenerateData.randomPlace().name)
                    .build());
            var ininstitution2 = institutionRepository.save(Institution.builder()
                    .description(GenerateData.randomPlace().description)
                    .name(GenerateData.randomPlace().name)
                    .build());
            var ininstitution3 = institutionRepository.save(Institution.builder()
                    .description(GenerateData.randomPlace().description)
                    .name(GenerateData.randomPlace().name)
                    .build());

            var dish1 = dishRepository.save(Dish.builder()
                    .name(GenerateData.randomDish().name)
                    .price(100)
                    .typeDish(GenerateData.randomDish().type)
                    .institution(ininstitution1)
                    .build());
            var dish2 = dishRepository.save(Dish.builder()
                    .name(GenerateData.randomDish().name)
                    .price(110)
                    .typeDish(GenerateData.randomDish().type)
                    .institution(ininstitution2)
                    .build());
            var dish3 = dishRepository.save(Dish.builder()
                    .name(GenerateData.randomDish().name)
                    .price(120)
                    .typeDish(GenerateData.randomDish().type)
                    .institution(ininstitution3)
                    .build());


            var order1 = orderRepository.save(Order.builder()
                    .orderLate(LocalDate.now())
                    .orderedDish(dish1)
                    .customer(customer1)
                    .build());
            var order2 = orderRepository.save(Order.builder()
                    .orderLate(LocalDate.now())
                    .orderedDish(dish1)
                    .customer(customer1)
                    .build());
            var order3 = orderRepository.save(Order.builder()
                    .orderLate(LocalDate.now())
                    .orderedDish(dish2)
                    .customer(customer2)
                    .build());
            var order4 = orderRepository.save(Order.builder()
                    .orderLate(LocalDate.now())
                    .orderedDish(dish2)
                    .customer(customer2)
                    .build());
            var order5 = orderRepository.save(Order.builder()
                    .orderLate(LocalDate.now())
                    .orderedDish(dish3)
                    .customer(customer3)
                    .build());
            var order6 = orderRepository.save(Order.builder()
                    .orderLate(LocalDate.now())
                    .orderedDish(dish3)
                    .customer(customer3)
                    .build());
        };
    }
}
