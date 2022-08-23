package com.example.demo.service;

import com.example.demo.exception.NoGradeException;
import com.example.demo.exception.NoSpecialtyException;
import com.example.demo.model.Specialty;
import com.example.demo.model.Student;
import com.example.demo.repository.SpecialtyRepository;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    private final StudentRepository studentRepository;

    public List<Student> getAllStudentBySpecialty(Integer specialtyId) throws NoSpecialtyException {
        Optional<Specialty> tmpOptionalSpecialty = specialtyRepository.findById(specialtyId);
        if(tmpOptionalSpecialty.isEmpty()){
            throw new NoSpecialtyException();
        } else {
            return tmpOptionalSpecialty.get().getStudentList();
        }
    }

    public Integer getAverageSpecialty(Integer specialtyId) throws NoGradeException {
        Optional<Specialty> specialty = specialtyRepository.findById(specialtyId);
        return specialty.get().getSpecialtyAverageScore();
    }


    public Integer highestMarkOfASpecialty(Integer specialtyId) throws NoGradeException {
        Optional<Specialty> specialty = specialtyRepository.findById(specialtyId);
        return specialty.get().highestMarkOfASpecialty();
    }

    public Specialty getSpecialtyWithTheMostStudents(){
        return specialtyRepository.findAll()
                .stream()
                .max(Comparator
                .comparing(student -> student.getStudentList().size())).get();
    }



}
