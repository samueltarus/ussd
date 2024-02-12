package com.ussd.ussd.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "ussds")
@AllArgsConstructor
@NoArgsConstructor
public class Ussd  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;

    private String name;
    private String next;
    private String action;
    private String validation;
    private String terminate;
    private String tag;
}
