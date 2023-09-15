package com.customer.customerservice.service.customer;

import com.customer.customerservice.domain.Customer;
import com.customer.customerservice.enums.Gender;
import com.customer.customerservice.model.CustomerRequestDto;

import java.util.List;

public interface CustomerService {

     Customer create(CustomerRequestDto customerRequestDto,Gender gender);

     Customer getCustomer(int id);

    List<Customer> getCustomers();

    Customer updateCustomer(int id,CustomerRequestDto customerRequestDto);

    Customer updateGenderByCustomer(int id, Gender gender);
    String deleteCustomer(int id);

}
