package com.sergioruy.booking;

import com.sergioruy.customer.Customer;
import com.sergioruy.customer.CustomerService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/booking-cli")
public class BookingResource {

    @Inject
    @RestClient
    BookingService bookingService;

    @Inject
    @RestClient
    CustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("newBooking")
    public String newBooking() {
        Customer customer = customerService.findById(2);
        Booking booking = Booking.of(0, customer);
        return bookingService.newBooking(booking);
    }
}
