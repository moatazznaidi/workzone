package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import jakarta.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Tasks")

public class Tasks {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Nullable
    @Column(name = "idSprint" )
    private Long idSprint;
    @Enumerated(EnumType.STRING)
    @Column(name = "TaskName" , nullable = true)
    private TicketNameEnum TaskName;

    @Column(name = "Description" , nullable = true)
    private String Description;

    @Column(name = "EstimatedTime" , nullable = true)
    private String EstimatedTime;

    @Column(name = "Progress" , nullable = true)
    private Integer Progress;

    @Column(name = "Priority" , nullable = true)
    private String Priority;
    @Column(name = "TaskStartDate" , nullable = true)
    private Date TaskStartDate;

    @Column(name = "TasksEndDate" , nullable = true)
    private Date TasksEndDate;

    @Column(name = "AssignedTo" )
    private Integer AssignedTo;
    @Column(name = "name" , nullable = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "TaskType" , nullable = true)
    private TicketTypeEnum TaskType;



}
