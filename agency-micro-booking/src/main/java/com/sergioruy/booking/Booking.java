package com.sergioruy.booking;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Booking extends PanacheEntity {

    public long idCustomer;
}
