package com.woniu.service.impl;

import com.woniu.dao.IUserDao;
import com.woniu.dao.impl.UserDaoImpl;
import com.woniu.entity.User;
import com.woniu.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao ud = new UserDaoImpl();
	@Override
	public void regist(User user) {
		ud.save(user);
	}
	@Override
	public boolean isNameExit(String name) {
		User u = ud.getUesrByName(name);
		return u != null;
	}
	
}
