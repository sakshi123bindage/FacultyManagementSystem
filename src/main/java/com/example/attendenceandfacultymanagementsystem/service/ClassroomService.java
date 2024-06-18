package com.example.attendenceandfacultymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendenceandfacultymanagementsystem.dao.ClassroomDao;
import com.example.attendenceandfacultymanagementsystem.entity.Classroom;

@Service
public class ClassroomService 
{
    @Autowired
    private ClassroomDao classroomDao;
    public String insertClassroom(Classroom classroom)
    {
    	if(classroomDao.insertClassroom(classroom))
    	{
    		return "Classroom info inserted successfully";
    	}
    	else
    	{
    		return "Classroom info not inserted";
    	}
    }
	public List<Classroom> getAllClassroom() {
		if(classroomDao.getAllClassroom()!=null)
		{
			return classroomDao.getAllClassroom();
		}
		else
		{
			return null;
		}
	}
	public List<Classroom> getClassroomById(long id) {
	     if(classroomDao.getClassroomById(id)!=null)
			{
				return classroomDao.getClassroomById(id);
			}
			else
			{
				return null;
			}
	}
	public String updateClassroom(long id, String name) {
		if(classroomDao.updateClassroom(id,name))
		{
			return "Updated Successfully";
		}
		else
		{
			return "Not updated successfully";
		}
	}
	public String deleteClassroomById(long id) {
		if(classroomDao.deleteClassroomById(id))
		{
			return "deleted successfully";
		}
		else
		{
			return "not deleted";
		}
	}
}
