package com.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.domain.User;
import com.mybatis.persistence.UserMapper;
import com.mybatis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional(readOnly = true)
	public List<User> getUserList(User user) {
		return userMapper.getUserList(user);
	}

	@Transactional(readOnly = true)
	public User getUser(int id) {
		return userMapper.getUser(id);
	}

	@Transactional(rollbackFor = Exception.class)
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Transactional(rollbackFor = Exception.class)
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteUser(int id) {
		userMapper.deleteUser(id);
	}
}
