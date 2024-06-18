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

@Repository
public class DepartmentDao
{
	@Autowired
	SessionFactory factory;

	public boolean insertDepartment(Department department) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(department);
		transaction.commit();
		return true;
	}

	public List<Department> getAllDepartment() 
	{
        Session session=factory.openSession();
        Criteria criteria=session.createCriteria(Department.class);
        return criteria.list();
	}

	public List<Department> getDepartmentById(long id) 
	{
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Department.class);
		criteria.add(Restrictions.eq("id", id));
		transaction.commit();
		return criteria.list();
	}

	public boolean updateDepartment(long id, String name) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Department.class);
		criteria.add(Restrictions.eq("id",id));
		List<Department> result=criteria.list();
		for(Department department:result)
		{
			department.setName(name);
			session.update(department);
		}
		transaction.commit();
		return true;
	}

	public boolean deleteDepartmentById(long id) {
		Session session = factory.openSession();
		Transaction transaction=session.beginTransaction();
        Department department= session.get(Department.class, id);
        if (department != null) {
            session.delete(department);
        }
        transaction.commit();
		return true;
	}
}
