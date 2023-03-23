package com.sergioruy.booking;

import com.sergioruy.custumer.Customer;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Booking extends PanacheEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    public Customer customer;
}
