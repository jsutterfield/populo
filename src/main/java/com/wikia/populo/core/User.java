package com.wikia.populo.core;

import javax.validation.constraints.NotNull;

public class User {
    @NotNull
    private final String name;
    private final String email;
    private final Integer id;

    public User(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFoo() {
        return "This is foo";
    }
}