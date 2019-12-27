package com.cp.dao;

import com.cp.model.User;

import java.util.List;

public interface UserModuleDao {

    public User loginUser(String uid, String password);

    public List<User> findUserAll();

    public int addUser(User user);

    public User getUser(int id);

    public int updateUser(User user);

    public int deleteUser(int id);

}
