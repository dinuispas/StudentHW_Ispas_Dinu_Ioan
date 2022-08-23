package com.example.demo.model;

import com.example.demo.exception.NoGradeException;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull


    @OneToMany
    List<Grade> grades = new ArrayList<Grade>();

    @Transient
    List<Student> students = new ArrayList<>();



    @NotNull
    @ManyToOne
    Specialty specialty;


    public Integer getAnnualAverageGrade() throws NoGradeException {

        if(grades.isEmpty()){
            throw new NoGradeException();
        } else {
            Integer averageGrade = 0;
            for(Grade grade: grades){
                averageGrade += grade.getGrade();
            }
            return averageGrade/grades.size();
        }

    }

    public Student getHighestMarkOfAStudent() throws NoGradeException {
        Integer maxGrade = 0;
        Student student1 = new Student();
        for(Student student:students){
            if(student.getAnnualAverageGrade() > maxGrade){
                maxGrade = student.getAnnualAverageGrade();
                student1 = student;
            }

        }
        return student1;
    }









}
