package com.ussd.ussd.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Options  implements Serializable {
    private Long id;
    private String title;
}
