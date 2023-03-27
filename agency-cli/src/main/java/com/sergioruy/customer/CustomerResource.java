package com.sergioruy.customer;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/customer-cli")
public class CustomerResource {

    @Inject
    @RestClient
    CustomerService customerService;

    @GET
    @Path("newCustomer")
    public String newCustomer() {
        Customer customer = Customer.of(99, "Remote");
        return customerService.newCustomer(customer);
    }
}
