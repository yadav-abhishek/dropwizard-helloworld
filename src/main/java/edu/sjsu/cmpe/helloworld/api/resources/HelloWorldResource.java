package edu.sjsu.cmpe.helloworld.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

import edu.sjsu.cmpe.helloworld.domain.HelloMessage;

@Path("/helloworld")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    public HelloWorldResource() {
    }

    @GET
    @Timed(name = "get-requests")
    public HelloMessage get(@QueryParam("name") Optional<String> name) {
        HelloMessage hello = new HelloMessage();
        hello.setMessage("Hello" + ( (name.isPresent()) ? " " + name.get() : ""));
        return hello;
    }
}

