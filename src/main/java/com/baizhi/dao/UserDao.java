package com.baizhi.dao;
import com.baizhi.entity.User;
public interface UserDao {
    public User selectUser(String name);
}
