package com.example.OneToMany.Service;

import com.example.OneToMany.Entity.Course;
import com.example.OneToMany.Entity.Instructor;
import com.example.OneToMany.Repository.CourseRepository;
import com.example.OneToMany.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public void Add(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    @Override
    public Optional<Instructor> getById(Long id) {
        return instructorRepository.findById(id);
    }

    @Override
    public List<Instructor> getAll() {
        return instructorRepository.findAll();
    }

    @Override
    public void DeleteById(Long id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public Instructor updateById(Instructor instructor, Long id,Long courseId) {
        Optional<Instructor> optionalInstructor=instructorRepository.findById(id);
       String newTıtle=instructor.getCourses().get(Math.toIntExact(1)).getTitle();
        if(optionalInstructor.isPresent()){
            optionalInstructor.get().setEmail(instructor.getEmail());
            optionalInstructor.get().setFirstName(instructor.getFirstName());
            optionalInstructor.get().setFirstName(instructor.getLastName());
            optionalInstructor.get().getCourses().get(Math.toIntExact(courseId)).setTitle(newTıtle);
            instructorRepository.saveAll(List.of(optionalInstructor.get()));
            //courseRepository.save(course.get().setTitle(instructor.getCourses().get(Integer.parseInt(String.valueOf(id))).getTitle()));


        }
        return null;
    }
}
