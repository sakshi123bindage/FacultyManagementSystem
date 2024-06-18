package com.example.attendenceandfacultymanagementsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.attendenceandfacultymanagementsystem.entity.Classroom;
import com.example.attendenceandfacultymanagementsystem.entity.Department;
import com.example.attendenceandfacultymanagementsystem.entity.Faculty;

@Repository
public class FacultyDao
{
	@Autowired
	SessionFactory factory;
	public boolean insertFaculty(Faculty faculty) {
	    Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(faculty);
		transaction.commit();
		return true;
	}
	public List<Faculty> getAllFaculty() {
		Session session=factory.openSession();
		Criteria criteria=session.createCriteria(Faculty.class);
		return criteria.list();
	}
	public List<Faculty> getFacultyById(long id) 
	{
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Faculty.class);
		criteria.add(Restrictions.eq("id", id));
		transaction.commit();
		return criteria.list();
	}
	public boolean updateFaculty(long id, String email) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Faculty.class);
		criteria.add(Restrictions.eq("id", id));
		List<Faculty> result=criteria.list();
		for(Faculty faculty:result)
		{
			faculty.setEmail(email);
			session.update(faculty);
		}
		transaction.commit();
		return true;
	}
	public boolean deleteFaculty(long id) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Faculty faculty=session.get(Faculty.class, id);
		if(faculty!=null)
		{
			session.delete(faculty);
		}
		transaction.commit();
		return true;
	}
}
