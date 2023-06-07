package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Mail")

public class Mail {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;


    @Column(name = "destinataire" )
    private String destinataire ;
    @Column(name = "object" )
    private String object;

    @Column(name = "message" )
    private String message;

    @Column(name = "attachement" )
    private String attachement;
}
