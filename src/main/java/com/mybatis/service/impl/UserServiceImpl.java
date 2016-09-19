package com.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.domain.User;
import com.mybatis.persistence.UserMapper;
import com.mybatis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public PageInfo<User> getUserList(String name, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<User> users = userMapper.getUserList(name);
		return new PageInfo<>(users);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
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
