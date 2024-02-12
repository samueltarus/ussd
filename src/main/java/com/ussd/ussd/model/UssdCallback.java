package com.ussd.ussd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UssdCallback  implements Serializable {
    private String title;
    private List<Options> options;
    private String back;
    private String logout;
}
