
package com.swagger.bootstrap.ui.demo.config;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.github.xiaoymin.swaggerbootstrapui.model.OrderExtensions;
import com.github.xiaoymin.swaggerbootstrapui.model.SpringAddtionalModel;
import com.github.xiaoymin.swaggerbootstrapui.service.SpringAddtionalModelService;
import com.google.common.collect.Lists;
import com.swagger.bootstrap.ui.demo.extend.DeveloperApiInfo;
import com.swagger.bootstrap.ui.demo.extend.DeveloperApiInfoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpSession;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    @Autowired
    SpringAddtionalModelService springAddtionalModelService;


    private final TypeResolver typeResolver;

    @Autowired
    public SwaggerConfiguration(TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }

   /* @Bean
    public UiConfiguration uiConfiguration(){
        return UiConfigurationBuilder.builder().supportedSubmitMethods(new String[]{"get"})
                .displayOperationId(true)
                .build();
    }*/
   @Bean(value = "defaultApix")
   public Docket defaultApixx() {
       ParameterBuilder parameterBuilder=new ParameterBuilder();
       List<Parameter> parameters= Lists.newArrayList();

       Docket docket=new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(apiInfo())
               .groupName("默认接口-swaggermodels")
               .select()
               .apis(RequestHandlerSelectors.basePackage("com.swagger.bootstrap.ui.demo.x200"))
               //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
               .paths(PathSelectors.any())
               .build().extensions(Lists.newArrayList(new OrderExtensions(1))).globalOperationParameters(parameters)
               .securityContexts(Lists.newArrayList(securityContext())).securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey()));
       return docket;
   }

    @Bean(value = "defaultApi")
    public Docket defaultApi() {
        ParameterBuilder parameterBuilder=new ParameterBuilder();
        List<Parameter> parameters= Lists.newArrayList();
        parameterBuilder.name("token").description("token令牌").modelRef(new ModelRef("String"))
                .parameterType("header")
                .required(true).build();
        parameters.add(parameterBuilder.build());

        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("默认接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swagger.bootstrap.ui.demo.controller"))
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build().extensions(Lists.newArrayList(new OrderExtensions(1))).globalOperationParameters(parameters)
                .securityContexts(Lists.newArrayList(securityContext())).securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey()));
        return docket;
    }
    @Bean(value = "groupRestApi")
    public Docket groupRestApi() {
        List<ResolvedType> list=Lists.newArrayList();

        //SpringAddtionalModel springAddtionalModel= springAddtionalModelService.scan("com.swagger.bootstrap.ui.demo.extend");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .groupName("1.8.X版本接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swagger.bootstrap.ui.demo.x180"))
                .paths(PathSelectors.any())
                .build()
                .additionalModels(typeResolver.resolve(DeveloperApiInfo.class)).extensions(Lists.newArrayList(new OrderExtensions(2))).securityContexts(Lists.newArrayList(securityContext(),securityContext1())).securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey(),apiKey1()));
    }
    @Bean(value = "groupRestApi1")
    public Docket groupRestApi1() {
        List<ResolvedType> list=Lists.newArrayList();

        //SpringAddtionalModel springAddtionalModel= springAddtionalModelService.scan("com.swagger.bootstrap.ui.demo.extend");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .groupName("1.9.X版本接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swagger.bootstrap.ui.demo.x190"))
                .paths(PathSelectors.any())
                .build()
                .additionalModels(typeResolver.resolve(DeveloperApiInfo.class)).extensions(Lists.newArrayList(new OrderExtensions(2))).securityContexts(Lists.newArrayList(securityContext(),securityContext1())).securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey(),apiKey1()));
    }
    private ApiInfo groupApiInfo(){
        DeveloperApiInfoExtension apiInfoExtension=new DeveloperApiInfoExtension();

        apiInfoExtension.addDeveloper(new DeveloperApiInfo("张三","zhangsan@163.com","Java"))
        .addDeveloper(new DeveloperApiInfo("李四","lisi@163.com","Java"));


        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui很棒~~~！！！")
                .description("<div style='font-size:14px;color:red;'>swagger-bootstrap-ui-demo RESTful APIs</div>")
                .termsOfServiceUrl("http://www.group.com/")
                .contact("group@qq.com")
                .version("1.0")
                .extensions(Lists.newArrayList(apiInfoExtension))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui-demo RESTful APIs")
                .description("# swagger-bootstrap-ui-demo RESTful APIs")
                .termsOfServiceUrl("http://www.xx.com/")
                .contact("xx@qq.com")
                .version("1.0")
                .build();
    }

    private ApiKey apiKey() {
        //HttpHeaders.AUTHORIZATION
        return new ApiKey("BearerToken", "Authorization", "header");
    }
    private ApiKey apiKey1() {
        return new ApiKey("BearerToken1", "Authorization-c", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }
    private SecurityContext securityContext1() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth1())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }
    List<SecurityReference> defaultAuth1() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken1", authorizationScopes));
    }

}
