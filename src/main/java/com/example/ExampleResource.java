package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces({MediaType.TEXT_PLAIN, MediaType.TEXT_HTML})
    public ExampleDto hello() {
        return new ExampleDto("test");
    }
}
