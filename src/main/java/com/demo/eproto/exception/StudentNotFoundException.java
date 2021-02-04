package com.demo.eproto.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException() {
        super("Student Not Found");
    }

}

