package com.ussd.ussd.model;

import java.io.Serializable;
import org.springframework.stereotype.Service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "ussd_session")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UssdSession  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "session_id")
    private String sessionId;
    @Column(name = "ussd_step")

    private String ussdStep;
    @Column(name = "msisdn")
    private String msisdn;
    @Column(name = "language")
    private String language;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "responses")
    private String responses;
    @Column(name = "account_action")
    private String accountAction;
    @Column(name = "id_type")
    private String idtype;
    @Column(name = "action_id")
    private String actionId;


}
