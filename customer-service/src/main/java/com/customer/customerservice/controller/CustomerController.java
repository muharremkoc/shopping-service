package com.customer.customerservice.controller;

import com.customer.customerservice.domain.Customer;
import com.customer.customerservice.enums.Gender;
import com.customer.customerservice.model.CustomerRequestDto;
import com.customer.customerservice.service.customer.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/versions/1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("")
    public Customer createCustomer(@RequestBody CustomerRequestDto customerRequestDto, @RequestParam Gender gender){
        return customerService.create(customerRequestDto, gender);
    }
    @GetMapping("")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") int id){
        return customerService.getCustomer(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") int id,@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.updateCustomer(id,customerRequestDto);
    }

    @PatchMapping("/{id}")
    public Customer updateCustomerForGender(@PathVariable("id") int id,@RequestParam Gender gender){
        return customerService.updateGenderByCustomer(id,gender);
    }
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        return customerService.deleteCustomer(id);
    }
}
