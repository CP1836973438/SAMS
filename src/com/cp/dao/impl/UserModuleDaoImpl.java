package com.cp.dao.impl;

import com.cp.dao.UserModuleDao;
import com.cp.model.Student;
import com.cp.model.User;
import com.cp.util.DBCommon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModuleDaoImpl implements UserModuleDao {

    @Override
    public User loginUser(String uid, String password) {
        User user = null;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBCommon.getConnection();
            String sql = "select * from user where uid = ? and password = ?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setString(1, uid);
            ps.setString(2, password);
            rs = DBCommon.getResultSet(ps);
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUid(rs.getString("uid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps, rs);
        }

        return user;
    }

    @Override
    public List<User> findUserAll() {
        List<User> users = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBCommon.getConnection();
            String sql = "SELECT * from user";
            ps = DBCommon.getPreparedStatement(sql, con);
            rs = DBCommon.getResultSet(ps);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUid(rs.getString("uid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps, rs);
        }

        return users;
    }

    @Override
    public int addUser(User user) {
        int addCount = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBCommon.getConnection();
            String sql = "insert into user(uid, username, password) values(?, ?, ?)";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setString(1, user.getUid());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            addCount = DBCommon.executeUpdateBySql(ps);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps);
        }

        return addCount;
    }

    @Override
    public User getUser(int id) {
        User user = new User();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBCommon.getConnection();
            String sql = "SELECT * FROM user where id = ?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setInt(1, id);
            rs = DBCommon.getResultSet(ps);
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUid(rs.getString("uid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps, rs);
        }

        return user;
    }

    @Override
    public int updateUser(User user) {
        int updateCount = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBCommon.getConnection();
            String sql = "update user set uid = ?, username = ?, password = ? where id = ?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setString(1, user.getUid());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getId());
            updateCount = DBCommon.executeUpdateBySql(ps);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps);
        }

        return updateCount;
    }

    @Override
    public int deleteUser(int id) {
        int deleteCount = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBCommon.getConnection();
            String sql = "delete from user where id=?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setInt(1, id);
            deleteCount = DBCommon.executeUpdateBySql(ps);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps);
        }

        return deleteCount;
    }
}
