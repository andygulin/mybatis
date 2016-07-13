package com.mybatis.service;

import java.util.List;

import com.mybatis.domain.User;

public interface UserService {

	List<User> getUserList(User user);

	User getUser(int id);

	void updateUser(User user);

	void insertUser(User user);

	void deleteUser(int id);
}
