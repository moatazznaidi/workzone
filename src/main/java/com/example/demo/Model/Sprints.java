package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import jakarta.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Sprint")
public class Sprints {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Nullable
    @Column(name = "idProject" , nullable = true)
    private Long idProject;
    @Column(name = "SprintName" , nullable = true)
    private String SprintName;
    @Column(name = "Description" , nullable = true)
    private String Description;

    @Column(name = "SprintStartDate" , nullable = true)
    private java.sql.Date SprintStartDate;
    @Column(name = "SprintEndDate" , nullable = true)
    private Date SprintEndDate;

}
