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
import com.example.attendenceandfacultymanagementsystem.entity.Course;

@Repository
public class CourseDao 
{
   @Autowired
   SessionFactory factory;
   public boolean insertCourse(Course course) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(course);
		transaction.commit();
		return true;
	}
	public List<Course> getAllCourse() 
	{
	   Session session=factory.openSession();
	   Criteria criteria=session.createCriteria(Course.class);
	   return criteria.list();
    }
	public List<Course> getCourseById(int id)
	{
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Course.class);
		criteria.add(Restrictions.eq("id", id));
		transaction.commit();
		return criteria.list();
	}
	public boolean updateCourse(int id, String name)
	{
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Course.class);
		criteria.add(Restrictions.eq("id",id));
		List<Course> result=criteria.list();
		for(Course course:result)
		{
			course.setName(name);
			session.update(course);
		}
		transaction.commit();
		return true;
	}
	public boolean deleteCourseById(int id) {
		Session session = factory.openSession();
		Transaction transaction=session.beginTransaction();
        Course course= session.get(Course.class, id);
        if (course != null) {
            session.delete(course);
        }
        transaction.commit();
		return true;
	}
}
