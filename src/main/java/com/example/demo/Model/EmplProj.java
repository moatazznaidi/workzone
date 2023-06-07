package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EmplProj")
public class EmplProj {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name = "idEmployee" )
    private Long id_employee ;
    @Column(name = "idProject" )
    private Long id_project;
    @Column(name = "id_role" )
    private Long id_role ;
}
