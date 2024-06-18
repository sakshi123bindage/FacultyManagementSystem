package com.example.attendenceandfacultymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendenceandfacultymanagementsystem.dao.FacultyDao;
import com.example.attendenceandfacultymanagementsystem.entity.Faculty;

@Service
public class FacultyService 
{
	@Autowired
   private FacultyDao facultyDao;
   public String insertFaculty(Faculty faculty)
   {
	   if(facultyDao.insertFaculty(faculty))
	   {
		   return "Faculty inserted successfully";
	   }
	   else
	   {
		   return "Faculty is not inserted successfully";
	   }
   }

	public List<Faculty> getAllFaculty() {
	   if(facultyDao.getAllFaculty()!=null)
	   {
		   return facultyDao.getAllFaculty();
	   }
	   else
	   {
		   return null;
	   }
   }

	public List<Faculty> getFacultyById(long id) 
	{
		if(facultyDao.getFacultyById(id)!=null)
		{
			return facultyDao.getFacultyById(id);
		}
		else
		{
			return null;
		}
	}

	public String updateFaculty(long id, String email) {
		if(facultyDao.updateFaculty(id,email))
		{
			return "faculty updated successfully";
		}
		else
		{
			return "faculty not updated";
		}
	}

	public String deleteFaculty(long id) {
		if(facultyDao.deleteFaculty(id))
		{
			return "faculty is deleted";
		}
		else
		{
			return "faculty is not deleted";
		}
	}

	
}
