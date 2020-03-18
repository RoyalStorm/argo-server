package com.arrayteam.argo.server.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.arrayteam.argo.server.controller"))
                .build()
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("API for AR service to create effects of augmented reality \"ARGO\"")
                                .version("0.1")
                                .build()
                )
                .pathMapping("/")
                .produces(new HashSet<>(Collections.singletonList("application/json")))
                .consumes(new HashSet<>(Collections.singletonList("application/json")))
                .globalResponseMessage(RequestMethod.GET, responseMessages())
                .globalResponseMessage(RequestMethod.POST, responseMessages())
                .globalResponseMessage(RequestMethod.PUT, responseMessages())
                .globalResponseMessage(RequestMethod.PATCH, responseMessages())
                .globalResponseMessage(RequestMethod.DELETE, responseMessages())
                .tags(
                        new Tag("TargetController", "Control work with markers"),
                        new Tag("ARCController", "Control the type of tracking, markers and virtual content"),
                        new Tag("VirtualContentController", "Control work with virtual content")
                );
    }

    private List<ResponseMessage> responseMessages() {
        return Arrays.asList(
                new ResponseMessageBuilder()
                        .code(HttpStatus.OK.value())
                        .message("OK")
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpStatus.NO_CONTENT.value())
                        .message("No content")
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .message("Bad request")
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpStatus.UNAUTHORIZED.value())
                        .message("You are not authorized to view the resource")
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpStatus.FORBIDDEN.value())
                        .message("Accessing the resource you were trying to reach is forbidden")
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpStatus.NOT_FOUND.value())
                        .message("The resource you were trying to reach is not found")
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message("Internal error")
                        .build()
        );
    }

}
