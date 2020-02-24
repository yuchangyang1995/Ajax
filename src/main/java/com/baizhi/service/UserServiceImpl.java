package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.util.DBUtil;

public class UserServiceImpl implements UserService {
    @Override
    public User show(String name) {
        UserDao userDao=(UserDao) DBUtil.getDaoImpl(UserDao.class);
        User user = userDao.selectUser(name);
        DBUtil.commit();
        return user;
    }
}
