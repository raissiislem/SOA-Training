package webservices;

import io.swagger.jaxrs.config.BeanConfig;

public class SwaggerConfig {

    public SwaggerConfig() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("Gestion UE API");
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setBasePath("http://localhost:8083/Gestion_UE_VF_war_exploded/"); // match Main ApplicationPath
        beanConfig.setResourcePackage("webservices");
        beanConfig.setScan(true);
    }
}
