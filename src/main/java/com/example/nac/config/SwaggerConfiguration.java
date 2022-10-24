package com.example.nac.config;

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
public class SwaggerConfiguration {

    //Swagger 객체 생성
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.nac"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("국회 일정 어플리케이션 RESTful API")
                .description("현재 달력 JSON 출력 API까지 개발\n" +
                        "개발 예정\n" +
                        "1. 날짜별 일정\n" +
                        "2. 소팅기능(본회의, 정기회의, 기자회견)\n" +
                        "3. 로그인\n")
                .version("1.0.0")
                .build();
    }
}
