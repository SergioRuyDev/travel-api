package com.sergioruy.booking;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bookings")
public class BookingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Booking> get() {
        return Booking.listAll();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Booking newBooking(Booking booking) {
        booking.id = null;
        booking.persist();

        return booking;
    }
}
