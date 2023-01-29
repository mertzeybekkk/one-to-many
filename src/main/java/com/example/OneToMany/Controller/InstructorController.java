package com.example.OneToMany.Controller;

import com.example.OneToMany.Entity.Instructor;
import com.example.OneToMany.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/get/data")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @PostMapping("/add")
    public void Add(@RequestBody Instructor instructor){
        instructorService.Add(instructor);
    }
    @GetMapping("/getId/{id}")
    public Optional<Instructor> getById(@PathVariable Long id){
        return instructorService.getById(id);
    }
    @GetMapping("/getAll")
    public List<Instructor> getAll(){
        return instructorService.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public  void DeleteById(@PathVariable Long id){
        instructorService.DeleteById(id);
    }
    @PutMapping("/updateInstructor/{id}/{courseId}")
    public Instructor update(@RequestBody Instructor instructor,@PathVariable Long id,@PathVariable Long courseId){
        return  instructorService.updateById(instructor,id,courseId);
    }
}

