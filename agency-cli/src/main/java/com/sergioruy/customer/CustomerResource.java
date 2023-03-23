package com.sergioruy.customer;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/customer-cli")
public class CustomerResource {

    @Inject
    @RestClient
    CustomerService customerService;

    @GET
    @Path("newCustomer")
    public Response newCustomer() {
        Customer customer = Customer.of(99, "Remote");
        Response response = customerService.newCustomer(customer);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }
}
