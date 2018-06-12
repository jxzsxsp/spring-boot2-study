package cn.xiaoshuiping.springbootwebflux.router;

import cn.xiaoshuiping.springbootwebflux.handler.HelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Sean.Xiao
 * @date 2018/6/10 下午7:27
 */
@Configuration
public class HelloRouter {

    @Bean
    public RouterFunction<ServerResponse> routeCity(HelloHandler helloHandler) {
        return RouterFunctions
                .route(
                        RequestPredicates.GET("/hello")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                helloHandler::helloCity);
    }
}
