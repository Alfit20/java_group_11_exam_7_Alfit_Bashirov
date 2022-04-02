package com.example.java_11_exam_7_alfit_bashirov.repository;

import com.example.java_11_exam_7_alfit_bashirov.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> getByEmail(String email);
}
