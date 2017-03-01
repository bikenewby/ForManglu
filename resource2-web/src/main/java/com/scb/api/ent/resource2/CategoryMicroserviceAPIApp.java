package com.scb.api.ent.resource2;

/**
 * Created by ...... on ....
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import com.scb.api.common.framework.utility.ELKLogger;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
// Include com.scb.api.common.framework on ComponentScan to bootstrap the SCB API Framework
// Include com.scb.api.ent.resource2 on ComponentScan to include all components of this microservice inplementation (including components from Domain and Stub projects)
@ComponentScan(basePackages = "com.scb.api.common.framework, com.scb.api.ent.resource2")
public class CategoryMicroserviceAPIApp {

    private static ELKLogger log = new ELKLogger(CategoryMicroserviceAPIApp.class);

    public static void main(String[] args) {
        SpringApplication.run(CategoryMicroserviceAPIApp.class, args);
        log.info("call http://host:port/scb/rest/ent-api/swagger-ui.html to access Swagger UI of this Mircoservice");
    }

    //--------- FOR SPRINGFOX SWAGGER UI (only single implementation per mircoservice application) ---------------------
    @Bean
    public Docket api() {
        Docket thisDocket;
        thisDocket = new Docket(DocumentationType.SWAGGER_2)
                // Optional
                .groupName("Enterprise APIs")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                // Ensure to properly specify the proper version number of this API as part of URL path below
                .paths(regex("/v1.*"))
                .build();
        return thisDocket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SCB Enterprise RESTful API")
                .contact(new Contact("IBM Thailand Co.,Ltd.", "", "sudduenk@gmail.com"))
                .description("SCB Enterprise RESTful API for CASA project")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("1.0")
                .build();
    }
}
