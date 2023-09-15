package com.customer.customerservice.model;


public class CustomerRequestDto {

    private String customerName;

    public CustomerRequestDto(String customerName) {
        this.customerName = customerName;
    }

    public CustomerRequestDto() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
