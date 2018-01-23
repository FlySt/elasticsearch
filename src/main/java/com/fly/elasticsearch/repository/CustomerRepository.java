package com.fly.elasticsearch.repository;

import com.fly.elasticsearch.domain.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;


/**
 * @author Fly
 * @Description
 * @Date Created in 9:30 2018/1/23
 * @Modified by
 */
public interface CustomerRepository extends ElasticsearchCrudRepository<Customer,Long> {

}
