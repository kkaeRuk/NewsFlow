package com.example.demo.config;

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
   @Bean
    public Docket swaggerApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(swaggerInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/**"))
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo swaggerInfo(){
        return new ApiInfoBuilder().title("Spring API Documentation")
                .description("앱 개발시 사용되는 서버 API에 대한 연동 문서입니다.")
                .license("bomin").version("1").build();
    }
 /*@Bean
 public Docket api() {
     return new Docket(DocumentationType.SWAGGER_2)
             .select()
             .apis(RequestHandlerSelectors.any())
             //현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
             .paths(PathSelectors.ant("/**"))
             //그중 /api/**인 URL들만 필터링
             .build();
 }*/
}
