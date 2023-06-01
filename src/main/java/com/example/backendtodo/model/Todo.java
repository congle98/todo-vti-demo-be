package com.example.backendtodo.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Todo {
    private int id;
    private String description;
}
