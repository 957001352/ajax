package com.woniu.service;

import com.woniu.entity.User;

public interface IUserService {
	void regist(User user);
	boolean isNameExit(String name);
}
