package com.learn.SpringbootMongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "account")
public class Account {
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String password;
    @DBRef
    private List<Role> roles = new ArrayList<>();
}
