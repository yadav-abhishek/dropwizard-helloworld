package edu.sjsu.cmpe.helloworld;

import org.codehaus.jackson.map.Module;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.json.Json;

import edu.sjsu.cmpe.helloworld.api.resources.HelloWorldResource;
import edu.sjsu.cmpe.helloworld.config.CustomJson;
import edu.sjsu.cmpe.helloworld.config.HelloWorldServiceConfiguration;

public class HelloWorldService extends Service<HelloWorldServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloWorldService().run(args);
    }

	private HelloWorldService() {
		super("helloworld");
	}

	@Override
	protected void initialize(HelloWorldServiceConfiguration configuration,
			Environment environment) throws Exception {

		environment.addResource(HelloWorldResource.class);

	}

	@Override
	public Json getJson() {
		final CustomJson json = new CustomJson();
        for (Module module : getJacksonModules()) {
            json.registerModule(module);
        }
        return json;
	}

}
