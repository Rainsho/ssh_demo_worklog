package com.rainsho.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", catalog = "etc_log")
public class Users implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uid;
	private String username;
	private String password;
	private String realname;
	private Short admin;
	private Set<Logs> logses = new HashSet<Logs>(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String username, String password, String realname, Short admin) {
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.admin = admin;
	}

	/** full constructor */
	public Users(String username, String password, String realname,
			Short admin, Set<Logs> logses) {
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.admin = admin;
		this.logses = logses;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "uid", unique = true, nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "username", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "realname", nullable = false, length = 50)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "admin", nullable = false)
	public Short getAdmin() {
		return this.admin;
	}

	public void setAdmin(Short admin) {
		this.admin = admin;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "users")
	public Set<Logs> getLogses() {
		return this.logses;
	}

	public void setLogses(Set<Logs> logses) {
		this.logses = logses;
	}

}