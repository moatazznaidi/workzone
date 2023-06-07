package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TasksProject")
public class TasksProject {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "idProject" )
    private Long idProject;
    @Enumerated(EnumType.STRING)
    @Column(name = "TaskNameProject" , nullable = true)
    private TicketNameEnum TaskNameProject;
    @Column(name = "Description" , nullable = true)
    private String Description;

    @Column(name = "EstimatedTime" , nullable = true)
    private String EstimatedTime;

    @Column(name = "Progress" , nullable = true)
    private String Progress;

    @Column(name = "Priority" , nullable = true)
    private String Priority;
    @Column(name = "TaskStartDate" , nullable = true)
    private Date TaskStartDate;

    @Column(name = "TasksEndDate" , nullable = true)
    private Date TasksEndDate;

    @Column(name = "AssignedTo" , nullable = true)
    private Integer AssignedTo;
    @Enumerated(EnumType.STRING)
    @Column(name = "TaskProjectType" , nullable = true)
    private TicketTypeEnum TaskProjectType;
    @Column(name = "name" , nullable = true)
    private String name;


}
