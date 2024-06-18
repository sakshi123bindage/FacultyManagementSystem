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
import com.example.attendenceandfacultymanagementsystem.entity.Department;
import com.example.attendenceandfacultymanagementsystem.service.ClassroomService;
import com.example.attendenceandfacultymanagementsystem.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	 @Autowired
	    private DepartmentService departmentService;
	    
	    @PostMapping("/insertDepartment")
	    public String insertDepartment(@RequestBody Department department)
	    {
	    	return departmentService.insertDepartment(department);
	    }
	    
	    @GetMapping("/getAllDepartment")
	    public List<Department> getAllDepartment()
	    {
	    	return departmentService.getAllDepartment();
	    }
	    
	    @GetMapping("/getDepartmentById/{id}") 
	    public List<Department> getDepartmentById(@PathVariable long id)
	    {
	    	return departmentService.getDepartmentById(id);
	    }
	    
	    @PutMapping("/updateDepartment/{id}/{name}")
	    public String updateDepartment(@PathVariable long id,@PathVariable String name)
	    {
	    	return departmentService.updateDepartment(id,name);
	    }
	    
	    @DeleteMapping("/deleteDepartmentById/{id}")
	    public String deleteDepartmentById(@PathVariable long id)
	    {
	    	return departmentService.deleteDepartmentById(id);
	    }
	    
}
