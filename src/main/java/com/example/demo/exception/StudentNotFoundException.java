package com.example.demo.exception;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(){
        super("Student does not exist");
    }
}
