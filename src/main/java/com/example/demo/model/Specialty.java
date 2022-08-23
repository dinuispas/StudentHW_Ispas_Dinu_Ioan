package com.example.demo.model;

import com.example.demo.exception.NoGradeException;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull

    @OneToMany
    List<Student> studentList = new ArrayList<>();

    @OneToMany
    List<Course> courses = new ArrayList<>();

    public Integer getSpecialtyAverageScore() throws NoGradeException {

        Integer finalAverage = 0;
        for(Student student: studentList){
            finalAverage += student.getAnnualAverageGrade();
        }
        return finalAverage/studentList.size();

    }


    public Integer highestMarkOfASpecialty() throws NoGradeException {
        Integer max = 0;
        Integer id = 0;
        for(Student student:studentList){
            if(student.getAnnualAverageGrade() > max){
                max = student.getAnnualAverageGrade();
                id = student.getId();
            }

        }
        return id;
    }


}
