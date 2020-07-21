package com.hangyu.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * 文档分组展示
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //安全管理员
    public static final String SAFE_ADMIN_PACKAGE = "com.hangyu.platform.web.safeAdmin.controller";
    public static final String SAFE_ADMIN_VERSION = "1.0";
    //系统管理员
    public static final String SYS_ADMIN_PACKAGE = "com.hangyu.platform.web.sysAdmin.controller";
    public static final String SYS_ADMIN_VERSION = "1.0";
    //日志管理员
    public static final String LOG_ADMIN_PACKAGE = "com.hangyu.platform.web.logAdmin.controller";
    public static final String LOG_ADMIN_VERSION = "1.0";
    //后台业务接口
    public static final String BACKGROUD_BUSINESS_PACKAGE = "com.hangyu.platform.web.backBusiness.controller";
    public static final String BACKGROUD_BUSINESS_VERSION = "1.0";


    @Bean
    public Docket createSafeAdminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("安全管理员接口")
                .apiInfo(apiSafeAdminInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SAFE_ADMIN_PACKAGE))//api接口包扫描路径
                .paths(PathSelectors.any())//可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeyList = new ArrayList();
        apiKeyList.add(new ApiKey("x-auth-token", "token", "header"));
        return apiKeyList;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build());
        return securityContexts;
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }

    private ApiInfo apiSafeAdminInfo() {
        return new ApiInfoBuilder()
                .title("安全管理员接口")//设置文档的标题
                .description("安全管理员接口")//设置文档的描述->1.Overview
                .version(SAFE_ADMIN_VERSION)//设置文档的版本信息-> 1.1 Version information
                .build();
    }


    @Bean
    public Docket createLogAdminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("日志管理员接口")
                .apiInfo(apiLogAdminInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(LOG_ADMIN_PACKAGE))//api接口包扫描路径
                .paths(PathSelectors.any())//可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    private ApiInfo apiLogAdminInfo() {
        return new ApiInfoBuilder()
                .title("日志管理员接口")//设置文档的标题
                .description("日志管理员接口")//设置文档的描述->1.Overview
                .version(LOG_ADMIN_VERSION)//设置文档的版本信息-> 1.1 Version information
                .build();
    }

    @Bean
    public Docket createSysAdminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("系统管理员接口")
                .apiInfo(apiSysAdminInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SYS_ADMIN_PACKAGE))//api接口包扫描路径
                .paths(PathSelectors.any())//可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    private ApiInfo apiSysAdminInfo() {
        return new ApiInfoBuilder()
                .title("系统管理员接口")//设置文档的标题
                .description("系统管理员接口")//设置文档的描述->1.Overview
                .version(SYS_ADMIN_VERSION)//设置文档的版本信息-> 1.1 Version information
                .build();
    }

    @Bean
    public Docket createBackBusinessApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("后台业务接口")
                .apiInfo(apiBackBusinessInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(BACKGROUD_BUSINESS_PACKAGE))//api接口包扫描路径
                .paths(PathSelectors.any())//可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiBackBusinessInfo() {
        return new ApiInfoBuilder()
                .title("后台业务接口")//设置文档的标题
                .description("后台业务接口")//设置文档的描述->1.Overview
                .version(BACKGROUD_BUSINESS_VERSION)//设置文档的版本信息-> 1.1 Version information
                .build();
    }


//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build()
//                //主要关注点--统一填写一次token
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("保密平台  api")
//                .description("描述")
//                .version("1.0")
//                .build();
//    }


}
