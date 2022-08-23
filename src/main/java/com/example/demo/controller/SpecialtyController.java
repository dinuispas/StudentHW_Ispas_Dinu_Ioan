package com.example.demo.controller;


import com.example.demo.exception.NoGradeException;
import com.example.demo.exception.NoSpecialtyException;
import com.example.demo.model.Specialty;
import com.example.demo.model.Student;
import com.example.demo.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("specialty")
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    @GetMapping("/studentsBySpecialty")
    public List<Student> getAllStudentsBySpecialty(@PathVariable Integer specialtyId) throws NoSpecialtyException {
        return specialtyService.getAllStudentBySpecialty(specialtyId);
    }

    @GetMapping("specialtyAverage")
    public Integer getSpecialtyAverage(@PathVariable Integer specialtyId) throws NoGradeException {
        return specialtyService.getAverageSpecialty(specialtyId);
    }

    @GetMapping("highestGradeFromASpecialty")
    public Integer getHighestMarkFromASpecialty(@PathVariable Integer specialtyId) throws NoGradeException {
        return specialtyService.highestMarkOfASpecialty(specialtyId);
    }

    @GetMapping("specialtyWithMost")
    public Specialty getSpecialtyWithMostStudents(){
        return specialtyService.getSpecialtyWithTheMostStudents();
    }



}
