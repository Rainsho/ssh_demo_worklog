package com.rainsho.service;

import java.util.List;

import com.rainsho.dao.UsersDAO;
import com.rainsho.entity.Users;

public class UserService {
	private UsersDAO dao;

	public UsersDAO getDao() {
		return dao;
	}

	public void setDao(UsersDAO dao) {
		this.dao = dao;
	}

	public boolean checkUser(Users user) {
		List<Users> users = dao.findByUsername(user.getUsername());
		if (users.size() == 0
				|| !users.get(0).getPassword().equals(user.getPassword())) {
			return false;
		}
		return true;
	}

	public Users findUser(Users user) {
		return dao.findByUsername(user.getUsername()).get(0);
	}

}
