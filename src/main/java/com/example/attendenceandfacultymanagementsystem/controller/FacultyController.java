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

import com.example.attendenceandfacultymanagementsystem.entity.Faculty;
import com.example.attendenceandfacultymanagementsystem.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController 
{
	@Autowired
	private FacultyService facultyService;
	@PostMapping("/insertFaculty")
   public String insertFaculty(@RequestBody Faculty faculty)
   {
	   return facultyService.insertFaculty(faculty);
   }
	
	@GetMapping("/getAllFaculty")
   public List<Faculty> getAllFaculty()
   {
	   return facultyService.getAllFaculty();
   }
	
   @GetMapping("/getFacultyById/{id}")
   public List<Faculty> getFacultyById(@PathVariable long id)
   {
	  return  facultyService.getFacultyById(id);
   }
	
   @PutMapping("/updateFaculty/{id}/{email}")
   public String updateFaculty(@PathVariable long id,@PathVariable String email)
   {
	  return  facultyService.updateFaculty(id,email);
   }
   
   @DeleteMapping("/deleteFaculty/{id}")
   public String deleteFaculty(@PathVariable long id)
   {
	  return facultyService.deleteFaculty(id);
   }
}
