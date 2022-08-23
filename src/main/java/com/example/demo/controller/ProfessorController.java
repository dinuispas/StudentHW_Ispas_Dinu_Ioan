package com.example.demo.controller;

import com.example.demo.exception.NoProfessorException;
import com.example.demo.model.Course;
import com.example.demo.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping("/byCourses")
    public List<Course> getAllProfessorsByCourse(@PathVariable Integer professorId) throws NoProfessorException {
        return professorService.getAllCoursesByProfessor(professorId);
    }

}
