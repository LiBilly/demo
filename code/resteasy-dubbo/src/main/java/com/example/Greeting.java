package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.awt.event.ActionListener;
import java.util.function.Function;
import java.util.function.Supplier;

@Path("greeting")
public class Greeting {

    @Path("{name}")
    @GET
    @Produces("text/plain")
    public String sayHello(@PathParam("name") String name) {
        return "Hello " + name;
    }

}
