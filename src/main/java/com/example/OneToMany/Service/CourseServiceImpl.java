package com.example.OneToMany.Service;

import com.example.OneToMany.Entity.Course;
import com.example.OneToMany.Entity.Instructor;
import com.example.OneToMany.Repository.CourseRepository;
import com.example.OneToMany.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourserService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private InstructorRepository instructorRepository;
    @Override
    public List<Course> getAll() {
      List<Course> courses=courseRepository.findAll();
        return courses ;
    }

    @Override
    public List<String> getById(Long id) {
        Optional<Course> courses = courseRepository.findById(id);
        List<String> courseList = null;
        if (Objects.nonNull(courses)) {
            courseList = new ArrayList<>();

            courseList.add(courses.get().getInstructor().getFirstName());
            courseList.add(courses.get().getInstructor().getLastName());
            courseList.add(courses.get().getTitle());
        }

        return courseList;
    }


    @Override
    public Optional<Course> updateCourse(Course course, Long id) {
        Optional<Course> optionalCourse= courseRepository.findById(id);
        optionalCourse.get().setInstructor(course.getInstructor());
        optionalCourse.get().setTitle(course.getTitle());
        courseRepository.save(optionalCourse.get());
        return optionalCourse;
    }

    @Override
    public void deleteCourse(Long id) {
         courseRepository.deleteById(id);
    }

    @Override
    public void addCourse(Course course,Long id) {
        Optional<Instructor> optionalInstructor= instructorRepository.findById(id);
        Course course1= new Course();
        course1.setTitle(course.getTitle());
        course1.setInstructor(optionalInstructor.get());
          courseRepository.save(course1);

    }
}
