package com.sunil__parcha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil__parcha.modal.User;
import com.sunil__parcha.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userDao;

	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public void add(User user) {
		userDao.add(user);

	}

	@Override
	public void update(User user) {
		userDao.update(user);

	}

	@Override
	public void delete(User user) {
		userDao.delete(user);

	}

	@Override
	public User findByUserId(String id) {
		return userDao.findByUserId(id);
	}

	@Override
	public List<User> findLikeUserName(String name) {
		return userDao.findLikeUserName(name);
	}

	@Override
	public List<User> AseAndDec(String name) {
		return userDao.AseAndDec(name);
	}

}
