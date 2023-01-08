package com.hcf.configurations;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // 路由id
        return routes.route("path_route_first",
                // 路由
                r -> r.path("/guangzhou")
                        // 映射地址
                        .uri("http://pc.nfapp.southcn.com/guangzhou")).build();

    }
}
