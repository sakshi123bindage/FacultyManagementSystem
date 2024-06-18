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

@Repository
public class ClassroomDao {
	@Autowired
	SessionFactory factory;

	public boolean insertClassroom(Classroom classroom) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(classroom);
		transaction.commit();
		return true;
	}

	public List<Classroom> getAllClassroom() 
	{
        Session session=factory.openSession();
        Criteria criteria=session.createCriteria(Classroom.class);
        return criteria.list();
	}

	public List<Classroom> getClassroomById(long id) 
	{
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Classroom.class);
		criteria.add(Restrictions.eq("id", id));
		transaction.commit();
		return criteria.list();
	}

	public boolean updateClassroom(long id, String name) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Classroom.class);
		criteria.add(Restrictions.eq("id",id));
		List<Classroom> result=criteria.list();
		for(Classroom classroom:result)
		{
			classroom.setName(name);
			session.update(classroom);
		}
		transaction.commit();
		return true;
	}

	public boolean deleteClassroomById(long id) {
		Session session = factory.openSession();
		Transaction transaction=session.beginTransaction();
        Classroom classroom= session.get(Classroom.class, id);
        if (classroom != null) {
            session.delete(classroom);
        }
        transaction.commit();
		return true;
	}
}
