package com.example.OneToMany.Controller;

import com.example.OneToMany.Entity.Course;
import com.example.OneToMany.Service.CourserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourserService courserService;
    @GetMapping("/all")
    public List<Course> getAll(){
        return courserService.getAll();
    }
    @GetMapping("/getId/{id}")
    public String GetById(@PathVariable Long id){
        return courserService.getById(id).toString();
    }
    @PostMapping("/update/{id}/{CourseId}")
    public Optional<Course> updateCourse(@RequestBody Course course, @PathVariable Long id, @PathVariable Long CourseId){
        return  courserService.updateCourse(course,id);
    }

    @PostMapping("/add/{id}")
    public void addCourse(@RequestBody Course course,@PathVariable Long id ){

        courserService.addCourse(course,id);
    }
}
