package com.sunil__parcha.repository;

import java.util.List;

import com.sunil__parcha.modal.User;

public interface UserRepo {
	
	public List<User> getUserList();

	public void add(User user);

	public void update(User user);

	public void delete(User user);

	public User findByUserId(String id);

	public List<User> findLikeUserName(String name);

	public List<User> AseAndDec(String string);

}
