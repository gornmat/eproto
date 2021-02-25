package com.demo.eproto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "students")
@Data
@NoArgsConstructor
public class Student {

    public Student(Long idParent, String clazz) {
        this.idParent = idParent;
        this.clazz = clazz;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private Long idParent;
    private String firstName;
    private String lastName;
    private String clazz;
}
