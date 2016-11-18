package com.rainsho.action;

import org.apache.struts2.ServletActionContext;

import com.rainsho.entity.Users;
import com.rainsho.service.UserService;

public class UserAction {

	private UserService service;
	private Users user;
	private String errormsg;

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String login() {
		if (service.checkUser(user)) {
			user = service.findUser(user);
			ServletActionContext.getRequest().getSession()
					.setAttribute("LOGIN_USER", user);
			ServletActionContext.getRequest().getSession()
					.removeAttribute("log_show");
			return "success";
		} else {
			ServletActionContext.getRequest().getSession()
					.removeAttribute("LOGIN_USER");
			errormsg = "账号或密码错误";
			return "input";
		}
	}

	public String logout() {
		ServletActionContext.getRequest().getSession()
				.removeAttribute("log_show");
		ServletActionContext.getRequest().getSession()
				.removeAttribute("LOGIN_USER");
		return "success";
	}

}
