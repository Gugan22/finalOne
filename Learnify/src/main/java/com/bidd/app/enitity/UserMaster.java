package com.bidd.app.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_master")
public class UserMaster {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "fName")
	private String firstName;
	
	@Column(name = "lName")
	private String lastName;
	
	@Column(name = "mail")
	private String mail;
	
	
	@Column(name = "sNo")
	private String studNumber;
	
	
	@Column(name = "pNo")
	private String parentNumber;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "pass")
	private String password;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "session_id")
	private String sessionId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getStudNumber() {
		return studNumber;
	}

	public void setStudNumber(String studNumber) {
		this.studNumber = studNumber;
	}

	public String getParentNumber() {
		return parentNumber;
	}

	public void setParentNumber(String parentNumber) {
		this.parentNumber = parentNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	

}
