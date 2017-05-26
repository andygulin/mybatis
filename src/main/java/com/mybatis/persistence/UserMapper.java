package com.mybatis.persistence;

import com.mybatis.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> getUserList(@Param("name") String name);

    User getUser(int id);

    void insertUser(User user);

    void updateUser(User user);

    @Delete("DELETE FROM user WHERE id = #{id,jdbcType=INTEGER}")
    void deleteUser(@Param("id") int id);
}
