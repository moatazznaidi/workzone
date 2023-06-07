package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ressourceproject")

public class RessourceProjet {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name = "idEmployee" )
    private Long id_employee ;
    @Column(name = "idProject" )
    private Long id_project;
    @Column(name = "id_role" )
    private Long id_role ;

    @Column(name = "libelle" )
    private String libelle ;
    @Column(name = "name" )
    private String name ;
    @Column(name = "first_name" )
    private String first_name ;
    @Column(name = "last_name" )
    private String last_name ;
}
