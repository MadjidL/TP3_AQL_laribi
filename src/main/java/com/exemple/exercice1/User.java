package com.exemple.exercice1;

public class User {
    private long id;
    private String name;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public long getId() { return id; }
    public String getName() { return name; }
}