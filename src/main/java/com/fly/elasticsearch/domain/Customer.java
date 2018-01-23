package com.fly.elasticsearch.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


/**
 * @author Fly
 * @Description
 * @Date Created in 9:26 2018/1/23
 * @Modified by
 */
@Document(indexName = "customer",type = "customer",shards = 1,replicas = 0,refreshInterval = "-1")
public class Customer {

    @Id
    private Long id;

    @Field(type = FieldType.text)
    private String firstName;

    @Field(type = FieldType.text)
    private String lastName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
