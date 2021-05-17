
package com.swagger.bootstrap.ui.demo.config;

import cn.hutool.core.collection.CollectionUtil;
import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2WebMvc
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

   /*@Bean
    public UiConfiguration uiConfiguration(){
        return UiConfigurationBuilder.builder()
                .supportedSubmitMethods(new String[]{"GET"})
                .build();
    }*/


   private final TypeResolver typeResolver;
   private final OpenApiExtensionResolver openApiExtensionResolver;

    @Autowired
    public SwaggerConfiguration(TypeResolver typeResolver, OpenApiExtensionResolver openApiExtensionResolver) {
        this.typeResolver = typeResolver;
        this.openApiExtensionResolver = openApiExtensionResolver;
    }


    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        //schema
        List<GrantType> grantTypes=new ArrayList<>();
        //简单模式implicit
        ImplicitGrant implicitGrant=new ImplicitGrant(new LoginEndpoint("http://localhost:8999/oauth/authorize"),"access_token");
        //grantTypes.add(implicitGrant);
        //授权码模式AuthorizationCodeGrant
        TokenRequestEndpoint tokenRequestEndpoint=new TokenRequestEndpoint("http://localhost:8999/oauth/authorize","app1","123");
        //TokenEndpoint tokenEndpoint=new TokenEndpoint("http://192.168.1.10:8080/oauth/token","access_token");
        TokenEndpoint tokenEndpoint=new TokenEndpoint("http://localhost:8999/oauth/token","access_token");
        AuthorizationCodeGrant authorizationCodeGrant=new AuthorizationCodeGrant(tokenRequestEndpoint,tokenEndpoint);
        //grantTypes.add(authorizationCodeGrant);
        //密码模式
        String passwordTokenUrl="http://localhost:8999/oauth/token";
        //String passwordTokenUrl="http://192.168.1.10:8080/oauth/token";
        ResourceOwnerPasswordCredentialsGrant resourceOwnerPasswordCredentialsGrant=new ResourceOwnerPasswordCredentialsGrant(passwordTokenUrl);
        //grantTypes.add(resourceOwnerPasswordCredentialsGrant);
        //客户端模式（client credentials）
        String clientTokenUrl="http://localhost:8999/oauth/token";
        //String clientTokenUrl="http://192.168.1.10:8080/oauth/token";
        ClientCredentialsGrant clientCredentialsGrant=new ClientCredentialsGrant(clientTokenUrl);
        grantTypes.add(clientCredentialsGrant);


        OAuth oAuth=new OAuthBuilder().name("oauth2")
                .grantTypes(grantTypes).build();
        //context
        //scope方位
        List<AuthorizationScope> scopes=new ArrayList<>();
        scopes.add(new AuthorizationScope("read","read all resources"));
        SecurityReference securityReference=new SecurityReference("oauth2",scopes.toArray(new AuthorizationScope[]{}));
        SecurityContext securityContext=new SecurityContext(CollectionUtil.newArrayList(securityReference),PathSelectors.ant("/api/**"));
        //schemas
        List<SecurityScheme> securitySchemes=CollectionUtil.newArrayList(oAuth);
        //securyContext
        List<SecurityContext> securityContexts=CollectionUtil.newArrayList(securityContext);
        List<Parameter> parameters=new ArrayList<>();
        parameters.add(new ParameterBuilder()
                .name("abroadId")
                .description("(公共参数)环境标识")
                .modelRef(new ModelRef("integer"))
                .defaultValue("0")
                .parameterType("query")
                .required(true)
                .build());
        String groupName="2.X版本";
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                //.host("https://www.baidu.com")
                .apiInfo(apiInfo())
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swagger.bootstrap.ui.demo.new2"))
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .enableUrlTemplating(false)
                .extensions(openApiExtensionResolver.buildExtensions(groupName))
                //.extensions(openApiExtensionResolver.buildSettingExtensions())
                //.globalOperationParameters(parameters)
                //.securityContexts(securityContexts).securitySchemes(securitySchemes);
                .securityContexts(CollectionUtil.newArrayList(securityContext()))
                .securitySchemes(CollectionUtil.newArrayList(apiKey()))
                ;
        return docket;
    }
    private List<ApiKey> securitySchemes() {
        return CollectionUtil.newArrayList(
                new ApiKey("JWT", "Authorization", "header"));
    }

    @Bean(value = "defaultApi")
    public Docket defaultApi() {


        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("3.默认接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swagger.bootstrap.ui.demo.controller"))
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .extensions(openApiExtensionResolver.buildExtensions("3.默认接口"))
                //.extensions(openApiExtensionResolver.buildSettingExtensions())
                //.securityContexts(CollectionUtil.newArrayList(securityContext()))
                //.securitySchemes(CollectionUtil.newArrayList(apiKey()));
        .securitySchemes(securitySchemes());
        return docket;
    }
    @Bean(value = "groupRestApi")
    public Docket groupRestApi() {
        List<ResolvedType> list=CollectionUtil.newArrayList();

        //SpringAddtionalModel springAddtionalModel= springAddtionalModelService.scan("com.swagger.bootstrap.ui.demo.extend");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .groupName("4.分组接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swagger.bootstrap.ui.demo.group"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo groupApiInfo(){
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui很棒~~~！！！")
                .description("<div style='font-size:14px;color:red;'>swagger-bootstrap-ui-demo RESTful APIs</div>")
                .termsOfServiceUrl("http://www.group.com/")
                .contact("group@qq.com")
                .version("1.0")
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //.title("swagger-bootstrap-ui-demo RESTful APIs")
                .description("# swagger-bootstrap-ui-demo RESTful APIs")
                .termsOfServiceUrl("http://www.xx.com/")
                .contact("xx@qq.com")
                .version("1.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }
    private ApiKey apiKey1() {
        return new ApiKey("BearerToken1", "Authorization-x", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                //.forPaths(PathSelectors.regex(".*?208.*$"))
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
        return CollectionUtil.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }
    List<SecurityReference> defaultAuth1() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return CollectionUtil.newArrayList(new SecurityReference("BearerToken1", authorizationScopes));
    }

}
