package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.sql.Date;
@Data
@Entity
@Table(name="vtaskprojectemployee")

public class VTaskProjectEmployee {
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


    @Column(name = "first_name" )
    private String FirstName;

    @Column(name = "last_name" )
    private String LastName;

    @Nullable
    @Column(name = "nametask" , nullable = true)
    private String nametask;

}
