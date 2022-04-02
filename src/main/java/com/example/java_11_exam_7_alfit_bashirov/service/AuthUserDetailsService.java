package com.example.java_11_exam_7_alfit_bashirov.service;

import com.example.java_11_exam_7_alfit_bashirov.dto.CustomerDto;
import com.example.java_11_exam_7_alfit_bashirov.entity.Customer;
import com.example.java_11_exam_7_alfit_bashirov.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.getByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Not found"));
    }

    public void registration(CustomerDto customerDto) {
        var email = customerRepository.findCustomerByEmail(customerDto.getEmail());
        if(email == null) {
            customerRepository.save(Customer.builder()
                    .name(customerDto.getName())
                    .email(customerDto.getEmail())
                    .password(encoder.encode(customerDto.getPassword()))
                    .build());
        } else {
            throw new IllegalArgumentException();
        }

    }
}
