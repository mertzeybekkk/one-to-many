package com.example.OneToMany.Repository;

import com.example.OneToMany.Entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {

}
