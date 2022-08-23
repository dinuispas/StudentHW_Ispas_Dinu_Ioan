package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCoursesCreditPointsGreaterThanThree(){
        return courseRepository.findAll()
                .stream()
                .filter((Course course) -> {
                    return course.getCreditPoints() >= 3;
                }).collect(Collectors.toList());
    }
}
