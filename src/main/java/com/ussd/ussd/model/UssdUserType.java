package com.ussd.ussd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


public enum UssdUserType {
    ACTIVE("Active"),

     INCATIVE("Inactive"),
     UNCONFIRMED ("Unconfirmed");
     private String name;

    UssdUserType(String name) {
        this.name = name;
    }
}
