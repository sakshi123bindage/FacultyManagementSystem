package com.example.attendenceandfacultymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendenceandfacultymanagementsystem.dao.CourseDao;
import com.example.attendenceandfacultymanagementsystem.entity.Course;

@Service
public class CourseService 
{
    @Autowired
    private CourseDao courseDao;
    
    public String insertCourse(Course course)
    {
    	if(courseDao.insertCourse(course))
    	{
    		return "Course Inserted Successfully";
    	}
    	else
    	{
    		return "Course not inserted";
    	}
    }

	public List<Course> getAllCourse() 
	{
		if(courseDao.getAllCourse()!=null)
		{
			return courseDao.getAllCourse();
		}
		else
		{
			return null;
		}
	}
	public List<Course> getCourseById(int id)
	{
		if(courseDao.getCourseById(id)!=null)
		{
			return courseDao.getCourseById(id);
		}
		else
		{
			return null;
		}
	}

	public String updateCourse(int id, String name) {
		if(courseDao.updateCourse(id,name))
    	{
    		return "Course updated Successfully";
    	}
    	else
    	{
    		return "Course not updated";
    	}
	}

	public String deleteCourseById(int id) 
	{
		if(courseDao.deleteCourseById(id))
    	{
    		return "Course Deleted Successfully";
    	}
    	else
    	{
    		return "Course not deleted";
    	}
	}
}
