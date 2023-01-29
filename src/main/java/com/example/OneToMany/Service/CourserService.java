package com.example.OneToMany.Service;

import com.example.OneToMany.Entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourserService {
    List<Course> getAll();
    List<String> getById(Long id);
    Optional<Course> updateCourse(Course course, Long id);
    void deleteCourse(Long id);
    void addCourse(Course course,Long id);

}
