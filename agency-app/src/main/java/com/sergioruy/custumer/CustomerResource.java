package com.sergioruy.custumer;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customers")
public class CustomerResource {

    @GET // http://localhost:8080/customers
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> get() {
        return Customer.listAll();
    }

    @GET
    @Path("findById") // http://localhost:8080/customers/findById?id=1
    @Produces(MediaType.APPLICATION_JSON)
    public Customer findById(@QueryParam("id") long id) {
        return Customer.findById(id);
    }

    @DELETE
    @Transactional
    @Path("deleteById")
    public void deleteById(long id) {
        Customer.deleteById(id);
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newCustomer(Customer customer) {
        customer.id = null;
        customer.persist();

        return Response.status(Response.Status.CREATED).entity(customer).build();
    }
}
