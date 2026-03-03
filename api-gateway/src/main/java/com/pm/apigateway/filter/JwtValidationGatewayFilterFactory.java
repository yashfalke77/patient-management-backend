package com.pm.apigateway.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class JwtValidationGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    private final WebClient webClient;

    public JwtValidationGatewayFilterFactory(WebClient.Builder webClientBuilder,
                                             @Value("${auth.service.url}") String authServiceUrl) {
        this.webClient = webClientBuilder.baseUrl(authServiceUrl).build();
    }

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {

            String token = exchange.getRequest()
                    .getHeaders()
                    .getFirst(HttpHeaders.AUTHORIZATION);

            if (token == null || !token.startsWith("Bearer ")) {
                return unauthorizedResponse(exchange);
            }

            return webClient.get()
                    .uri("/validate")
                    .header(HttpHeaders.AUTHORIZATION, token)
                    .retrieve()
                    .toBodilessEntity()
                    .flatMap(response -> chain.filter(exchange))
                    .onErrorResume(ex -> unauthorizedResponse(exchange));
        };
    }

    // ✅ Always write CORS headers before completing with 401
    private reactor.core.publisher.Mono<Void> unauthorizedResponse(
            org.springframework.web.server.ServerWebExchange exchange) {

        String origin = exchange.getRequest().getHeaders().getFirst(HttpHeaders.ORIGIN);

        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

        HttpHeaders responseHeaders = exchange.getResponse().getHeaders();

        if (origin != null) {
            responseHeaders.set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, origin);
            responseHeaders.set(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
            responseHeaders.set(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,
                    "GET, POST, PUT, DELETE, PATCH, OPTIONS");
            responseHeaders.set(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*");
        }

        return exchange.getResponse().setComplete();
    }
}