package com.natswell.examples;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/greet")
public class GreetingResource {
  @Inject Greeter greeter;

  @GET @Path("/serial")
  @Produces(MediaType.TEXT_PLAIN)
  public Response helloSerial() {
    return Response.ok(greeter.greetSerial()).build();
  }

  @GET @Path("/parallel")
  @Produces(MediaType.TEXT_PLAIN)
  public Response helloParallel() {
    return Response.ok(greeter.greet()).build();
  }
}