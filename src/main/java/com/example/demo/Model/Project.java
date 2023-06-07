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
@Table(name="Project")
public class Project {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Nullable
    @Column(name = "Name" , nullable = true)
    private String Name;
    @Column(name = "Description" , nullable = true)
    private String Description;
    @Column(name = "isPublic" , nullable = true)
    private Integer isPublic;
    @Column(name = "StartDate" , nullable = true)
    private Date StartDate;
    @Column(name = "EndDate" , nullable = true)
    private Date EndDate;
    @Column(name = "WorkStatus" , nullable = true)
    private String WorkStatus;

    @Column(name = "Team" , nullable = true)
    private String Team;
    @Column(name = "Progress" , nullable = true)
    private String Progress;
    @Column(name = "Client" , nullable = true)
    private String Client;
    @Column(name = "Priority" , nullable = true)
    private String Priority;
    @Column(name = "Price" , nullable = true)
    private String Price;

    @Column(name = "CreatedBy" , nullable = true)
    private String CreatedBy;





}
