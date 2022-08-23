package com.example.demo.service;

import com.example.demo.exception.NoProfessorException;
import com.example.demo.model.Course;
import com.example.demo.model.Professor;
import com.example.demo.repository.ProfessorRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<Course> getAllCoursesByProfessor(Integer professorId) throws NoProfessorException {
        Optional<Professor> tmpOptionalProfessor = professorRepository.findById(professorId);
        if(tmpOptionalProfessor.isEmpty()){
            throw new NoProfessorException();
        }else {
            return tmpOptionalProfessor.get().getCourses();
        }
    }

}
