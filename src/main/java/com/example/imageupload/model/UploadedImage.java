package com.example.imageupload.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "uploaded_images")
public class UploadedImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageData;

    private String extractedText;

    private String boldWords;

}
