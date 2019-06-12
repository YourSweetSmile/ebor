package com.example.ebor.config;

import com.example.ebor.common.Swagger2Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Autowired
    private Swagger2Settings swagger2Settings;

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swagger2Settings.isShow())
                //调用下面 apiInfo()方法
                .apiInfo(apiInfo())
                .select()
                //Controller 所在路径
                .apis(RequestHandlerSelectors.basePackage("com.example.ebor.controller"))
                .paths(PathSelectors.any())
                .build();

    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot 结合 swagger2 构建的 Restful API")
                .description("无人机数据分析系统")
                .termsOfServiceUrl("localhost:8088")
                .version("0.0.1")
                .build();
    }

}
