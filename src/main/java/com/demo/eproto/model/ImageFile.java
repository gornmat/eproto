package com.demo.eproto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "files")
@Data
@NoArgsConstructor
public class ImageFile {

    public ImageFile(Long idParent, String fileName, byte[] img) {
        this.idParent = idParent;
                this.fileName = fileName;
                this.img= img;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private Long idParent;
    private String fileName;
    private byte[] img;
}
