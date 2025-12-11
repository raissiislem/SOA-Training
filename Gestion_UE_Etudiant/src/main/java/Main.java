import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import webservices.SwaggerConfig;

@ApplicationPath("rest")
public class Main extends Application {

    public Main() {
        new SwaggerConfig();
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();

        // Register your REST controllers
        resources.add(webservices.HelloWorldService.class);

        // Register Swagger resources
        resources.add(ApiListingResource.class);
        resources.add(SwaggerSerializers.class);

        return resources;
    }
}
