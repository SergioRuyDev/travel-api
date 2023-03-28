package com.sergioruy.customer;

public class Customer {

    private long id;
    private String name;

    public Customer() {}

    private Customer(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Customer of(long id, String name) {
        return new Customer(id, name);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
