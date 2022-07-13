package com.learn.SpringbootMongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Address {
    private String city;
    private String country;
}
