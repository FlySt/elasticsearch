package com.fly.elasticsearch.config;

import com.fly.elasticsearch.handler.CustomerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author Fly
 * @Description
 * @Date Created in 13:56 2018/1/23
 * @Modified by
 */
@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction<ServerResponse> customerRouterFunction(CustomerHandler customerHandler){
        return route(GET("/customer"), customerHandler::list)
                .andRoute(POST("/customer"),customerHandler::save)
                .andRoute(GET("/customer/{id}"),customerHandler::getCustomer);
    }
}
