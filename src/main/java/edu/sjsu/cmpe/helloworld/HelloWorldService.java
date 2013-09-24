package edu.sjsu.cmpe.helloworld;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

import edu.sjsu.cmpe.helloworld.api.resources.HelloWorldResource;
import edu.sjsu.cmpe.helloworld.api.resources.JSONPResource;
import edu.sjsu.cmpe.helloworld.config.HelloWorldServiceConfiguration;

public class HelloWorldService extends Service<HelloWorldServiceConfiguration> {

    public static void main(String[] args) throws Exception {
	new HelloWorldService().run(args);
    }

    @Override
    public void initialize(Bootstrap<HelloWorldServiceConfiguration> bootstrap) {
	bootstrap.setName("helloworld-service");
    }

    @Override
    public void run(HelloWorldServiceConfiguration configuration,
	    Environment environment) throws Exception {
	environment.addResource(new HelloWorldResource());
	environment.addResource(new JSONPResource());
    }

}
