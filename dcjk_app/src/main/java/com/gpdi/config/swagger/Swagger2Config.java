package com.gpdi.config.swagger;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @desc: swagger 接口文档
 *
 * url: http://localhost:8087/dcjk/swagger-ui.html#/
 *
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {

    // 定义分隔符
    private static final String splitor = ";";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //此处添加需要扫描接口的包路径
                .apis(basePackage(
                        "com.gpdi.web.battery" + splitor +
                        "com.gpdi.web.calendar" + splitor +
                        "com.gpdi.web.item"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot添加 Swagger2 组件")
                .description("Spring Boot添加 Swagger2 组件")
                .version("1.0")
                .build();
    }

    /**
     * 重写basePackage方法，使能够实现多包访问
     * @author  jinhaoxun
     * @date 2019/1/26
     * @param
     */
    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }

}