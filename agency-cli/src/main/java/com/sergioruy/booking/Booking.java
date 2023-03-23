package com.sergioruy.booking;

import com.sergioruy.customer.Customer;

public class Booking {

    private Customer customer;

    private Booking(Customer customer) {
        this.customer = customer;
    }

    public static Booking of(Customer customer) {
        return new Booking(customer);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
