package com.exemple.exercice2;

public class Order {
    private long id;
    private String description;

    public Order(long id, String description) {
        this.id = id;
        this.description = description;
    }
    // Getters et setters (omis pour brièveté)
    public long getId() { return id; }
    public String getDescription() { return description; }
}