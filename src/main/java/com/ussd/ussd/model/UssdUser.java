package com.ussd.ussd.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ussd_users")
public class UssdUser  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String password;
    private String plainPassword;
    private UssdUserType status=UssdUserType.UNCONFIRMED;
    private String retryCount;
    private String phoneNumber;
    private String markAsRegisteredOnXi;


}
