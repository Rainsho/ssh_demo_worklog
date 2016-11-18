package com.rainsho.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rainsho.dao.LogsDAO;
import com.rainsho.entity.Logs;
import com.rainsho.entity.Users;

public class LogService {
	private LogsDAO dao;

	public LogsDAO getDao() {
		return dao;
	}

	public void setDao(LogsDAO dao) {
		this.dao = dao;
	}

	@SuppressWarnings("unchecked")
	public List<Logs> findByAdmin(Users user) {
		if (user.getAdmin() == 1) {
			return dao.findAll();
		} else {
			return dao.findByProperty("users.uid", user.getUid());
		}
	}

	public void addLog(Logs log) {
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("LOGIN_USER");
		log.setUsers(user);
		log.setCreatetime(new Timestamp(new Date().getTime()));
		dao.save(log);
	}

	public Logs findById(int id) {
		return dao.findById(id);
	}

	public void updateLog(Logs log) {
		dao.attachDirty(log);
	}

}
