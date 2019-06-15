package com.woniu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.woniu.entity.User;
import com.woniu.service.IUserService;
import com.woniu.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private IUserService service = new UserServiceImpl();
	
	public String save() throws IOException {
		service.regist(user);
		return null;
	}
	public void exits() throws IOException {
		String name = user.getName();
		boolean bb = service.isNameExit(name);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		if(bb) {
			out.print("已存在");
		}else {
			out.print("不存在");
		}
		out.close();
	}
	@Override
	public User getModel() {
		return user;
	}
	
}
