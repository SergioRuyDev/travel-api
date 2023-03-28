package com.sergioruy.customer;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/customer-cli")
public class CustomerResource {

    @Inject
    @RestClient
    CustomerService customerService;

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer findById(@QueryParam("id") long id) {
        return customerService.findById(id);
    }

    @GET
    @Path("newCustomer")
    public String newCustomer() {
        Customer customer = Customer.of(99, "Remote");
        return customerService.newCustomer(customer);
    }
}
