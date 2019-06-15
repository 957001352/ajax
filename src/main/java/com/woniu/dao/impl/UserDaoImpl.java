package com.woniu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.woniu.dao.IUserDao;
import com.woniu.entity.User;
import com.woniu.util.HibernateUtils;

public class UserDaoImpl implements IUserDao {
	
	@Override
	public void save(User user) {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		
		s.save(user);
		
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public void delete(Integer id) {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		
		User user = (User) s.get(User.class, id);
		s.delete(user);
		
		s.getTransaction().commit();
		s.close();

	}

	@Override
	public void update(User user) {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		
		s.update(user);
		
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public User find(Integer id) {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		
		User user = (User) s.get(User.class, id);
		
		s.getTransaction().commit();
		s.close();
		
		return user;
		
	}

	@Override
	public List<User> find() {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		
		String hql = "FROM user";
		Query q = s.createQuery(hql);
		List<User> list = q.list();
		
		
		s.getTransaction().commit();
		s.close();
		
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public User getUesrByName(String name) {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		
		System.out.println(name);
		String hql = "FROM User WHERE name='"+name+"'";
		Query q = s.createQuery(hql);
		User user = (User) q.uniqueResult();
		
		
		s.getTransaction().commit();
		s.close();
		
		return user;
	}

}
