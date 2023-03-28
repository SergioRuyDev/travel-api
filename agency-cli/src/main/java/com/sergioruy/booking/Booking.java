package com.sergioruy.booking;

public class Booking {

    private long id;
    private long idCustomer;

    public Booking() {
    }

    private Booking(long id, long idCustomer) {
        this.id = id;
        this.idCustomer = idCustomer;
    }

    public static Booking of(long id, long idCustomer) {
        return new Booking(id, idCustomer);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }
}
