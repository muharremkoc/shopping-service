package com.customer.customerservice.mapper;

import com.customer.customerservice.domain.Customer;
import com.customer.customerservice.model.CustomerRequestDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface CustomerMapper {

    Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto);
}
