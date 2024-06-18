package com.example.attendenceandfacultymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendenceandfacultymanagementsystem.dao.ClassroomDao;
import com.example.attendenceandfacultymanagementsystem.dao.DepartmentDao;
import com.example.attendenceandfacultymanagementsystem.entity.Classroom;
import com.example.attendenceandfacultymanagementsystem.entity.Department;

@Service
public class DepartmentService 
{
	 @Autowired
	    private DepartmentDao departmentDao;
	    public String insertDepartment(Department department)
	    {
	    	if(departmentDao.insertDepartment(department))
	    	{
	    		return "Department inserted successfully";
	    	}
	    	else
	    	{
	    		return "Department not inserted";
	    	}
	    }
		public List<Department> getAllDepartment() {
			if(departmentDao.getAllDepartment()!=null)
			{
				return departmentDao.getAllDepartment();
			}
			else
			{
				return null;
			}
		}
		public List<Department> getDepartmentById(long id) {
		     if(departmentDao.getDepartmentById(id)!=null)
				{
					return departmentDao.getDepartmentById(id);
				}
				else
				{
					return null;
				}
		}
		public String updateDepartment(long id, String name) {
			if(departmentDao.updateDepartment(id,name))
			{
				return "Updated Successfully";
			}
			else
			{
				return "Not updated successfully";
			}
		}
		public String deleteDepartmentById(long id) {
			if(departmentDao.deleteDepartmentById(id))
			{
				return "deleted successfully";
			}
			else
			{
				return "not deleted";
			}
		}
}
