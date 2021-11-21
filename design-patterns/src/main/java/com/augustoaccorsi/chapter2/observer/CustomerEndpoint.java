package com.augustoaccorsi.chapter2.observer;

import javax.ejb.Stateless;
import javax.enterprise.event.NotificationOptions;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.enterprise.event.Event;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ForkJoinPool;

@Stateless
@Path("/customers")
public class CustomerEndpoint {

    @Inject
    @CustomerEvent(CustomerEvent.Type.ADD)
    private Event<Customer> customerAddEvent;

    @Inject
    @CustomerEvent(CustomerEvent.Type.REMOVE)
    private Event<Customer> customerRemoveEvent;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void newCustomer(Customer customer){
        customerAddEvent.fireAsync(customer, NotificationOptions.ofExecutor(new ForkJoinPool(10)));
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeCustomer(Customer customer){
        CompletionStage<Customer> stage = customerRemoveEvent.fireAsync(customer);
        stage.handle((Customer event, Throwable ex) -> {
            for(Throwable t : ex.getSuppressed()){
                //log execpetions
            }
            return event;
        });
    }
}
