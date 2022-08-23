package com.example.demo.exception;

public class NoGradeException extends Exception{

    public NoGradeException(){
        super("The grade list is empty");
    }

}
