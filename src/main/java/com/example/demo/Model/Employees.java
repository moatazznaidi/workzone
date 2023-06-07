package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.descriptor.jdbc.VarbinaryJdbcType;


import java.sql.Types;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employees")
public class Employees {
    @Id
    @Column(name = "id" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    @Column(name = "FirstName" )
    private String FirstName;
    @Column(name = "LastName" )
    private String LastName;
    @Column(name = "Gender" )
    private String Gender;
    @Column(name = "Age" )
    private Integer Age;
    @Column(name = "Password")
    private String Password;
    @Column(name = "Description" , nullable = true)
    private String Description;
    @Column(name = "Adress" , nullable = true)
    private String Adress;
   // @Lob
   // @Type(type="org.hibernate.type.BinaryType")
    //@JdbcTypeCode(Types.BINARY)
   @JdbcType(VarbinaryJdbcType.class)
    @Column(name = "Picture", columnDefinition = "bytea" )
    private  byte[] Picture;

    @Column(name = "BirthdayDate" )
    private Date BirthdayDate;
    @Column(name = "Email")
    private String Email;
    @Column(name = "PhoneNumber" )
    private Long PhoneNumber;
    @Column(name = "Login" )
    private String Login;
    @Column(name="id_user")
    private Integer idUser;


}
