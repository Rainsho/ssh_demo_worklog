package com.rainsho.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rainsho.entity.Logs;
import com.rainsho.entity.Users;
import com.rainsho.service.LogService;

public class LogAction {
	private LogService service;
	private Users user;
	private List<Logs> logs;
	private Logs log;
	private int id;

	public LogService getService() {
		return service;
	}

	public void setService(LogService service) {
		this.service = service;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Logs> getLogs() {
		return logs;
	}

	public void setLogs(List<Logs> logs) {
		this.logs = logs;
	}

	public Logs getLog() {
		return log;
	}

	public void setLog(Logs log) {
		this.log = log;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String findLogs() {
		user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("LOGIN_USER");
		logs = service.findByAdmin(user);
		return "success";
	}

	public String addLog() {
		service.addLog(log);
		return "success";
	}

	public String findById() {
		log = service.findById(id);
		if (log == null) {
			ServletActionContext.getRequest().getSession()
					.setAttribute("log_show", log);
			return "success";
		}
		if (user.getAdmin() != 1 && log.getUsers().getUid() != user.getUid()) {
			log = null;
		}
		ServletActionContext.getRequest().getSession()
				.setAttribute("log_show", log);
		return "success";
	}

	public String logUpdate() {
		Logs newlog = service.findById(log.getLid());
		newlog.setTxt1(log.getTxt1());
		newlog.setTxt2(log.getTxt2());
		newlog.setTxt3(log.getTxt3());
		service.updateLog(newlog);
		return "success";
	}

}
