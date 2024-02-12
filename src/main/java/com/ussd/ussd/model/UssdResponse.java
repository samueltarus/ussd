package com.ussd.ussd.model;

import java.io.Serializable;

import lombok.Data;


@Data
public class UssdResponse   implements Serializable {
    private String code;
    private String language;
    private String response;
    private String target;
}
