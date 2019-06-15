package com.woniu.dao;

import java.util.List;

import com.woniu.entity.User;

public interface IUserDao {
	void save(User user);
	void delete(Integer id);
	void update(User user);
	User find(Integer id);
	List<User> find();
	
	User getUesrByName(String name);
}
