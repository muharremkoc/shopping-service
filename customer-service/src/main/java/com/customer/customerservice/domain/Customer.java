package com.customer.customerservice.domain;

import com.customer.customerservice.enums.Gender;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String customerName;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    public Customer(int id, String customerName, Gender gender) {
        this.id = id;
        this.customerName = customerName;
        this.gender = gender;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
