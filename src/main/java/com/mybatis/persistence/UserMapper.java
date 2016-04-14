package com.mybatis.persistence;

import java.util.List;

import com.mybatis.domain.User;

public interface UserMapper {

	List<User> getUserList(User user);

	User getUser(int id);

	void insertUser(User user);

	void updateUser(User user);

	void deleteUser(int id);
}
