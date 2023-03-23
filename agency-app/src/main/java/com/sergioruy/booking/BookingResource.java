package com.sergioruy.booking;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response newBooking(Booking booking) {
        booking.id = null;
        booking.persist();

        return Response.status(Response.Status.CREATED).entity(booking).build();
    }
}
