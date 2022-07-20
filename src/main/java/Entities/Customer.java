package Entities;

import lombok.Data;

public @Data class Customer {
    private long ID;
    private String name;
    private String surname;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }
}