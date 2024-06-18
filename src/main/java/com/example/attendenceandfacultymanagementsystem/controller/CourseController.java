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

import com.example.attendenceandfacultymanagementsystem.entity.Course;
import com.example.attendenceandfacultymanagementsystem.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController 
{
   @Autowired
   private CourseService courseService;
   
   @PostMapping("/insertCourse")
   public String insertCourse(@RequestBody Course course)
   {
	   return courseService.insertCourse(course);
   }
   
   @GetMapping("/getAllCourse")
   public List<Course> getAllCourse()
   {
	  return courseService.getAllCourse();
   }
    
   @GetMapping("/getCourseById/{id}")
   public List<Course> getCourseById(@PathVariable int id)
   {
	  return courseService.getCourseById(id);
   }
   @PutMapping("/updateCourse/{id}/{name}")
   public String updateCourse(@PathVariable int id,@PathVariable String name)
   {
   	return courseService.updateCourse(id,name);
   }
   @DeleteMapping("/deleteCourseById/{id}")
   public String deleteCourseById(@PathVariable int id)
   {
   	return courseService.deleteCourseById(id);
   }
   
}
