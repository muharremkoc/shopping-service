package com.customer.customerservice.service.publisher;

import com.customer.customerservice.domain.Customer;

public interface CustomerPublisherService {

    public Long publish(Customer customer);
}
