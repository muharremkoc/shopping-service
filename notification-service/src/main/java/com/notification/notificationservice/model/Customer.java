package com.notification.notificationservice.model;



import com.notification.notificationservice.enums.Gender;

import java.io.Serializable;

public class Customer implements Serializable {


    private int id;

    private String customerName;

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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", gender=" + gender +
                '}';
    }
}
