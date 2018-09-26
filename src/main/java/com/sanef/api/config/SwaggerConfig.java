package com.sanef.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private Environment environment;


    @Bean
    public Docket api(ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2)
                //.securitySchemes(securitySchema()).securityContexts(Arrays.asList(securityContext()))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }

    @Bean
    public ApiInfo apiInfo(Contact contact) {
        return new ApiInfoBuilder()
                .title(environment.getProperty("project.api.name"))
                .description(environment.getProperty("project.api.description"))
                .version(environment.getProperty("project.version"))
                .termsOfServiceUrl(environment.getProperty("project.url"))
                .license(environment.getProperty("project.licence"))
                .licenseUrl(environment.getProperty("project.licence.url"))
                .contact(contact).build();
    }

    @Bean
    public Contact contact() {
        return new Contact(environment.getProperty("project.name"), environment.getProperty("project.url"), environment.getProperty("project.email"));
    }

    private List<SecurityScheme> securitySchema() {
        LoginEndpoint loginEndpoint = new LoginEndpoint("http://localhost:8080/oauth/token");
        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant("http://localhost:8080/oauth/token");
        List<SecurityScheme> schemeList = new ArrayList<>();
        List<GrantType> gTypes = new ArrayList<>();
        gTypes.add(grantType);
        List<AuthorizationScope> authorizationScopes = new ArrayList<>();
/*

        Arrays.stream(AccessScope.values()).forEach(field -> {
            authorizationScopes.add(new AuthorizationScopeBuilder().scope(field.getName()).description(field.getDescription()).build());
        });
*/

        authorizationScopes.add(new AuthorizationScopeBuilder().scope("read").build());
        authorizationScopes.add(new AuthorizationScopeBuilder().scope("write").build());


        schemeList.add(new OAuth("oauth2", authorizationScopes, gTypes));
        return schemeList;
    }

    @Bean
    public SecurityConfiguration securityInfo() {
        return new SecurityConfiguration("gigy", "secret", "", "", "", ApiKeyVehicle.HEADER, "", " ");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
    }

    private List<SecurityReference> defaultAuth() {
        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[0];
        return Arrays.asList(new SecurityReference("oauth2", authorizationScopes));
    }
}
