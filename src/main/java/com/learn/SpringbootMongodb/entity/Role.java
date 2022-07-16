package com.learn.SpringbootMongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "role")
public class Role {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
}
