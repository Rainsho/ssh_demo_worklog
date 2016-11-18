package com.rainsho.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Logs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "logs", catalog = "etc_log")
public class Logs implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer lid;
	private Users users;
	private String txt1;
	private String txt2;
	private String txt3;
	private Timestamp createtime;

	// Constructors

	/** default constructor */
	public Logs() {
	}

	/** full constructor */
	public Logs(Users users, String txt1, String txt2, String txt3,
			Timestamp createtime) {
		this.users = users;
		this.txt1 = txt1;
		this.txt2 = txt2;
		this.txt3 = txt3;
		this.createtime = createtime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "lid", unique = true, nullable = false)
	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uid", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "txt1", nullable = false, length = 65535)
	public String getTxt1() {
		return this.txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	@Column(name = "txt2", nullable = false, length = 65535)
	public String getTxt2() {
		return this.txt2;
	}

	public void setTxt2(String txt2) {
		this.txt2 = txt2;
	}

	@Column(name = "txt3", nullable = false, length = 65535)
	public String getTxt3() {
		return this.txt3;
	}

	public void setTxt3(String txt3) {
		this.txt3 = txt3;
	}

	@Column(name = "createtime", nullable = false, length = 19)
	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

}