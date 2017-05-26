package com.mybatis.service;

import com.github.pagehelper.PageInfo;
import com.mybatis.domain.User;

public interface UserService {

    PageInfo<User> getUserList(String name, int pageNo, int pageSize);

    User getUser(int id);

    void updateUser(User user);

    void insertUser(User user);

    void deleteUser(int id);
}
