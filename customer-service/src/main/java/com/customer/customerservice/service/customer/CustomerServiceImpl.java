package com.customer.customerservice.service.customer;

import com.customer.customerservice.domain.Customer;
import com.customer.customerservice.enums.Gender;
import com.customer.customerservice.mapper.CustomerMapper;
import com.customer.customerservice.model.CustomerRequestDto;
import com.customer.customerservice.repository.CustomerRepository;
import com.customer.customerservice.service.publisher.CustomerPublisherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerMapper customerMapper;

    private final CustomerRepository customerRepository;

    private final CustomerPublisherService customerPublisherService;



    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository, CustomerPublisherService customerPublisherService) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
        this.customerPublisherService = customerPublisherService;
    }

    @Override
    public Customer create(CustomerRequestDto customerRequestDto,Gender gender) {
        logger.info("Create-Customer Service Started");

        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDto);
        customer.setGender(gender);
        customerRepository.save(customer);
        logger.info(String.format("Customer Saved Successfully with ID:%s",customer.getId()));
        customerPublisherService.publish(customer);
        return customer;
    }

    @Override
    public Customer getCustomer(int id) {
        logger.info("Get-Customer Service Started");

        Customer customer = customerRepository.findById(id);
        if (customer==null){
            logger.error(String.format("Customer Not Found with ID:%s",id));
        }
        logger.info(String.format("Customer Founded Success:%s",id));
        return customer;
    }

    @Override
    public List<Customer> getCustomers() {
        logger.info("List-Customer Service Started");

        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(int id, CustomerRequestDto customerRequestDto) {
        logger.info("Update-Customer Service Started");
        Customer customer = customerRepository.findById(id);
        if (customer==null){
            logger.error(String.format("Customer Not Found with ID:%s",id));
        }
            customer.setCustomerName(customerRequestDto.getCustomerName());

        customerRepository.save(customer);

        return customer;
    }

    @Override
    public Customer updateGenderByCustomer(int id, Gender gender) {
        logger.info("Update-Gender-By-Customer Service Started");

        Customer customer = customerRepository.findById(id);
        if (customer==null){
            logger.error(String.format("Customer Not Found with ID:%s",id));
        }
        customer.setGender(gender);

        customerRepository.save(customer);

        return customer;
    }

    @Override
    public String deleteCustomer(int id) {
        logger.info("Delete-Customer Service Started");

        Customer customer = customerRepository.findById(id);
        if (customer==null){
            logger.error(String.format("Customer Not Found with ID:%s",id));
        }
        customerRepository.deleteById(customer.getId());

        return "Customer Deleted ";
    }
}
