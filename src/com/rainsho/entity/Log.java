package com.rainsho.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
	private Integer lid;

	// private Integer uid;

	private Date createtime;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	// public Integer getUid() {
	// return uid;
	// }
	//
	// public void setUid(Integer uid) {
	// this.uid = uid;
	// }

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String fmt() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		return sdf.format(createtime);
	}

}