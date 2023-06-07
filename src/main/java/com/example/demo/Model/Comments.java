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
@Table(name="Comments")
public class Comments {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Nullable
    @Column(name = "Description" , nullable = true)
    private String Description;

    @Column(name = "Date" , nullable = true)
    private Date Date;

    @Column(name = "Commenter" , nullable = true)
    private Date Commenter;
    @Column(name = "idTasks" , nullable = true)
    private Date idTasks;
}

