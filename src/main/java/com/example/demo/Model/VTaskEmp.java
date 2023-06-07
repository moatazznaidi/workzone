package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="v_taskemployee")
public class VTaskEmp {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "assigned_to" )
    private Integer assignedTo;

    @Column(name = "description" )
    private String description;
    @Column(name = "estimated_time" )
    private String estimatedTime;
    @Column(name = "priority" )
    private String priority;

    @Column(name = "progress" )
    private Integer progress;
    @Column(name = "task_start_date" )
    private Date taskStartDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "task_type" )
    private TicketTypeEnum taskType;
    @Column(name = "tasks_end_date" )
    private Date tasksEndDate;

    @Column(name = "id_sprint" )
    private Integer idSprint;
    @Column(name = "name" )
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_name" )
    private TicketNameEnum taskName;

    @Column(name = "first_name" )
    private String FirstName;

    @Column(name = "last_name" )
    private String LastName;

}
