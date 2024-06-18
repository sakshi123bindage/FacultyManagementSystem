package com.example.attendenceandfacultymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendenceandfacultymanagementsystem.entity.Classroom;
import com.example.attendenceandfacultymanagementsystem.service.ClassroomService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/classroom")
public class ClassroomController 
{
    @Autowired
    private ClassroomService classroomService;
    
    @PostMapping("/insertClassroom")
    public String insertClassroom(@RequestBody Classroom classroom)
    {
    	return classroomService.insertClassroom(classroom);
    }
    
    @GetMapping("/getAllClassroom")
    public List<Classroom> getAllClassroom()
    {
    	return classroomService.getAllClassroom();
    }
    
    @GetMapping("/getClassroomById/{id}") 
    public void getClassroomById(@PathVariable long id)
    {
    	classroomService.getClassroomById(id);
    }
    
    @PutMapping("/updateClassroom/{id}/{name}")
    public String updateClassroom(@PathVariable long id,@PathVariable String name)
    {
    	return classroomService.updateClassroom(id,name);
    }
    
    @DeleteMapping("/deleteClassroomById/{id}")
    public String deleteClassroomById(@PathVariable long id)
    {
    	return classroomService.deleteClassroomById(id);
    }
    
}
