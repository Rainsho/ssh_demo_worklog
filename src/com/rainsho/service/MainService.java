package com.rainsho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainsho.dao.LogMapper;
import com.rainsho.dao.UserMapper;
import com.rainsho.entity.LogWithBLOBs;
import com.rainsho.entity.User;

@Service
public class MainService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private LogMapper logMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public LogMapper getLogMapper() {
		return logMapper;
	}

	public void setLogMapper(LogMapper logMapper) {
		this.logMapper = logMapper;
	}

	public List<LogWithBLOBs> findByAdmin(User user) {
		if (user.getAdmin() == 1) {
			return logMapper.selectAllLogs();
		} else {
			return logMapper.selectLogsByUid(user.getUid());
		}
	}

	public void addLog(LogWithBLOBs log) {
		logMapper.insert(log);
	}

	public LogWithBLOBs findById(int id) {
		return logMapper.selectByPrimaryKey(id);
	}

	public void updateLog(LogWithBLOBs log) {
		logMapper.updateByPrimaryKeyWithBLOBs(log);
	}

	public boolean checkUser(User user) {
		User user_ck = userMapper.selectByUsername(user.getUsername());
		if (user_ck == null
				|| !user_ck.getPassword().equals(user.getPassword())) {
			return false;
		}
		return true;
	}

	public User findUser(User user) {
		return userMapper.selectByUsername(user.getUsername());
	}
	
}