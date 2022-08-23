package com.example.demo.exception;

public class NoSpecialtyException extends Exception{
    public NoSpecialtyException(){
        super("The specialty does not exist");
    }
}
