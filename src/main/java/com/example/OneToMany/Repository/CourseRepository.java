package com.example.OneToMany.Repository;

import com.example.OneToMany.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
