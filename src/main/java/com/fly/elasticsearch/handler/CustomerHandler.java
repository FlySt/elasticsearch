package com.fly.elasticsearch.handler;

import com.fly.elasticsearch.domain.Customer;
import com.fly.elasticsearch.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @author Fly
 * @Description
 * @Date Created in 10:28 2018/1/23
 * @Modified by
 */
@Component
public class CustomerHandler {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * 查询顾客列表
     * @param request
     * @return
     */
    public Mono<ServerResponse> list(ServerRequest request){
        Flux<Customer> customerFlux = Flux.fromIterable(customerRepository.findAll());
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(customerFlux,Customer.class);
    }

    /**
     * 保存
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> save(ServerRequest serverRequest){
        Mono<Customer> customerMono = serverRequest.bodyToMono(Customer.class);
        customerRepository.save(customerMono.block());
        Mono<Void> voidMono = Mono.empty();
        return ServerResponse.ok().build(voidMono);
    }

    /**
     * 获取
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> getCustomer(ServerRequest serverRequest){
        Long id = Long.valueOf(serverRequest.pathVariable("id"));
        Mono<ServerResponse> nofFound = ServerResponse.notFound().build();
        Mono<Customer> customerMono = Mono.just(customerRepository.findById(id).get());
        return customerMono.flatMap(customer -> ServerResponse.ok().body(fromObject(customer))).switchIfEmpty(nofFound);
    }
}
