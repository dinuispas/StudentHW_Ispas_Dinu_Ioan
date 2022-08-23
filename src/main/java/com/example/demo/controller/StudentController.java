package com.example.demo.controller;

import com.example.demo.exception.NoGradeException;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Grade;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("posted")
    public List<Grade> getAllGradesByStudent(@PathVariable Integer studentId) throws StudentNotFoundException {
        return studentService.getAllGrades(studentId);
    }

    @GetMapping("posted8")
    public List<Student> getAllGradesByStudentHigherThanEight(){
        return studentService.getAllStudentsGradeGreaterThanEight();
    }

    @GetMapping("highestGradeOfAllStudents")
    public Integer getHighestGrade() throws NoGradeException {
        return studentService.getStudentWithHighestMark();
    }




}
