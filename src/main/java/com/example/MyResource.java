package com.example;

import com.sendgrid.SendGrid;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
@Produces("application/json")
@Consumes("application/json")
public class MyResource {

    @POST
    @Path("/hulu")
    public void hulu() {
        SendGrid sendGrid = new SendGrid("abcd");
    }
}
