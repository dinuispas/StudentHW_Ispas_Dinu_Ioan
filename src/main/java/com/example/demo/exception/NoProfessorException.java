package com.example.demo.exception;

public class NoProfessorException extends Exception{
    public NoProfessorException(){
        super("No professor found");
    }
}
