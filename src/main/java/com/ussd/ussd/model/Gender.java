package com.ussd.ussd.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    UNKNOWN("Unknown");

    private String name;

    Gender(String name) {
        this.name = name;
    }
}
