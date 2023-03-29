package com.sergioruy.customer;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.time.temporal.ChronoUnit;

@Path("/customer-cli")
public class CustomerResource {

    @Inject
    @RestClient
    CustomerService customerService;

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(unit = ChronoUnit.SECONDS, value = 3)
    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker(
            requestVolumeThreshold = 4,
            failureRatio = .5,
            delay = 6000,
            successThreshold = 1
    )
    public Customer findById(@QueryParam("id") long id) {
        return customerService.findById(id);
    }

    @GET
    @Path("newCustomer")
    public String newCustomer() {
        Customer customer = Customer.of(99, "Remote");
        return customerService.newCustomer(customer);
    }

    private Customer fallback(long id) {
        return Customer.of(0, "");
    }
}
