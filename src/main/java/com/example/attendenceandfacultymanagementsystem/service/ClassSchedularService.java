package com.example.attendenceandfacultymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendenceandfacultymanagementsystem.dao.ClassSchedularDao;
import com.example.attendenceandfacultymanagementsystem.entity.ClassSchedule;
import com.example.attendenceandfacultymanagementsystem.entity.Subject;

@Service
public class ClassSchedularService {
	@Autowired
	private ClassSchedularDao classSchedularDao;

	public String createClassSchedular(ClassSchedule classSchedule) {
		if (classSchedularDao.createClassSchedular(classSchedule)) {
			return "insert successully";
		} else {
			return "not inserted";
		}
	}

	public List<ClassSchedule> getAllSchedular() {
		if(classSchedularDao. getAllSchedular()!=null)
		   {
			   return classSchedularDao. getAllSchedular();
		   }
		   else
		   {
			   return null;
		   }
	}

	public List<ClassSchedule> getSchedularById(long id) {
		if(classSchedularDao.getSchedularById(id)!=null)
		{
			return classSchedularDao.getSchedularById(id);
		}
		else
		{
			return null;
		}
	}

	public String updateSchedular(long id, String dayOfWeek) {
		if(classSchedularDao.updateSchedular(id, dayOfWeek))
		{
			return "Schedule inserted";
		}
		else
		{
			return "not inserted";
		}
	}

	public String deleteSchedular(long id) {
		if(classSchedularDao.deleteSchedular(id))
		{
			return "schedule successfully";
		}
		else
		{
			return "schule not deleted";
		}
	}
}
