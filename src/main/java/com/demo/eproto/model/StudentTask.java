package com.demo.eproto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "student_tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTask {

    public StudentTask(Long idTask, Long idStudent, String description, LocalDate dueDate) {
        this.idTask = idTask;
        this.idStudent = idStudent;
        this.description = description;
        this.dueDate = dueDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private Long idTask;
    private Long idStudent;
    private String description;
    private String grade;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

}
