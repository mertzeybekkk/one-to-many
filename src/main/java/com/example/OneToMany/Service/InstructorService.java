package com.example.OneToMany.Service;

import com.example.OneToMany.Entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    void Add(Instructor instructor);
    Optional<Instructor> getById(Long id);
    List<Instructor> getAll();
    void DeleteById(Long id);
    Instructor updateById(Instructor instructor,Long id,Long courseId);
}
