package com.augustoaccorsi.chapter2.observer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.enterprise.event.Event;

@Stateless
@Path("/customers")
public class CustomerEndpoint {

    @Inject
    private Event<Customer> customerAddEvent;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void newCustomer(Customer customer){
        customerAddEvent.fire(customer);
    }
}
