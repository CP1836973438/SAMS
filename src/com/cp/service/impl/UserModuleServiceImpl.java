package com.cp.service.impl;

import com.cp.dao.impl.UserModuleDaoImpl;
import com.cp.model.User;
import com.cp.service.UserModuleService;

import java.util.List;

public class UserModuleServiceImpl implements UserModuleService {
    UserModuleDaoImpl umdi = new UserModuleDaoImpl();

    @Override
    public User loginUser(String uid, String password) {
        return umdi.loginUser(uid, password);
    }

    @Override
    public List<User> findUserAll() {
        return umdi.findUserAll();
    }

    @Override
    public int addUser(User user) {
        return umdi.addUser(user);
    }

    @Override
    public User getUser(int id) {
        return umdi.getUser(id);
    }

    @Override
    public int updateUser(User user) {
        return umdi.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return umdi.deleteUser(id);
    }
}
