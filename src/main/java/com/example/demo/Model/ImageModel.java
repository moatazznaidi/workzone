package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name = "image_model")

public class ImageModel {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name ;
    private String type ;
    @Column(length = 5000000)
    private byte [] picByte ;


    public ImageModel(String originalFilename, String contentType, byte[] bytes) {
        this.name =originalFilename;
        this.type=contentType;
        this.picByte=bytes ;
    }
}
