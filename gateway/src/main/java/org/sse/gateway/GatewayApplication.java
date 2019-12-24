package org.sse.gateway;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cbc
 */
@EnableZuulProxy
@SpringCloudApplication
@EnableSwagger2Doc
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Component
    @Primary
    @EnableAutoConfiguration
    class DocumentationConfig implements SwaggerResourcesProvider {
        @Override
        public List<SwaggerResource> get() {
            List resources = new ArrayList<>();
            resources.add(swaggerResource("data-service", "/data-service/v2/api-docs", "1.0"));
            resources.add(swaggerResource("user-service", "/user-service/v2/api-docs", "1.0"));
            resources.add(swaggerResource("metadata-service", "/metadata-service/v2/api-docs", "1.0"));
            resources.add(swaggerResource("community-service", "/community-service/v2/api-docs", "1.0"));
            resources.add(swaggerResource("dataset-service", "/dataset-service/v2/api-docs", "1.0"));
            resources.add(swaggerResource("model-service", "/model-service/v2/api-docs", "1.0"));
            resources.add(swaggerResource("train-service", "/train-service/v2/api-docs", "1.0"));
            return resources;
        }

        private SwaggerResource swaggerResource(String name, String location, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }

}
