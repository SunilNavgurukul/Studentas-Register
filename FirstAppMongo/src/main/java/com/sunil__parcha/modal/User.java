package com.sunil__parcha.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	@Id
	private String id;
	private String name;
	private String dateOfBirth;
	private String phoneNum;
	private String uniqueId;
	
	public User() {
		super();
	}
	
	public User(String id, String name, String dateOfBirth, String phoneNum, String uniqueId) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.phoneNum = phoneNum;
		this.uniqueId = uniqueId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
}

