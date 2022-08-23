package com.example.demo.service;

import com.example.demo.exception.NoGradeException;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Grade;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Grade> getAllGrades(Integer studentId) throws StudentNotFoundException {
        Optional<Student> tmpStudent = studentRepository.findById(studentId);
        if(tmpStudent.isEmpty()){
            throw new StudentNotFoundException();
        } else {
            Student tmpStudent1 = tmpStudent.get();
            return tmpStudent1.getGrades();
        }
    }

    public List<Student> getAllStudentsGradeGreaterThanEight(){
        return studentRepository.findAll()
                .stream()
                .filter((Student student) -> {
                    try {
                        return student.getAnnualAverageGrade() >= 8;
                    } catch (NoGradeException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
    }

    public Integer getStudentWithHighestMark() throws NoGradeException {
        return studentRepository.findAll()
                .stream()
                .max(Comparator.comparing(student -> student.getHighestMarkOfAStudent())).get();
        throw new NoGradeException();
    }













}
