package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces({MediaType.TEXT_PLAIN, MediaType.TEXT_HTML})
    public Response hello() {
        return Response.ok(new ExampleDto("test")).build();
    }
}
