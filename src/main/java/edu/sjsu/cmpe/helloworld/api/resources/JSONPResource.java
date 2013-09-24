package edu.sjsu.cmpe.helloworld.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.sun.jersey.api.json.JSONWithPadding;
import com.yammer.metrics.annotation.Timed;

import edu.sjsu.cmpe.helloworld.domain.HelloMessage;

@Path("/jsonp")
public class JSONPResource {

    public JSONPResource() {
	// do nothing
    }

    @GET
    @Timed(name = "get-hello-jsonp")
    @Produces({ "application/javascript" })
    public JSONWithPadding getHello(@QueryParam("callback") String callback) {
	HelloMessage hello = new HelloMessage();
	return new JSONWithPadding(hello, callback);
    }
}

