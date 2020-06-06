package com.sunil__parcha.service;

import java.util.List;

import com.sunil__parcha.modal.User;


public interface UserService {

	public List<User> getUserList();

	public void add(User user);

	public void update(User user);

	public void delete(User user);

	public User findByUserId(String id);
	
	public List<User> findLikeUserName(String id);

	public List<User> AseAndDec(String option);


}

