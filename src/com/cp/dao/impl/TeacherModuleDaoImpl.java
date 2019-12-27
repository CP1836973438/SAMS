package com.cp.dao.impl;

import com.cp.dao.TeacherModuleDao;
import com.cp.model.Teacher;
import com.cp.util.DBCommon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherModuleDaoImpl implements TeacherModuleDao {

    @Override
    public Teacher loginTeacher(String tid, String tpwd) {
        Teacher teacher = null;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBCommon.getConnection();
            String sql = "select * from teacher where tid = ? and tpwd = ?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setString(1, tid);
            ps.setString(2, tpwd);
            rs = DBCommon.getResultSet(ps);
            while (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setTid(rs.getString("tid"));
                teacher.setTname(rs.getString("tname"));
                teacher.setTpwd(rs.getString("tpwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps, rs);
        }

        return teacher;
    }

    @Override
    public List<Teacher> findTeaAll() {
        List<Teacher> teachers = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBCommon.getConnection();
            String sql = "SELECT t.id, t.tid, t.tname, c1.cname, c2.cname FROM teacher t LEFT JOIN class c1 ON t" +
                    ".t_class = c1.cid LEFT JOIN class c2 ON t.t_class2 = c2.cid";
            ps = DBCommon.getPreparedStatement(sql, con);
            rs = DBCommon.getResultSet(ps);
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("t.id"));
                teacher.setTid(rs.getString("t.tid"));
                teacher.setTname(rs.getString("t.tname"));
                teacher.setTclassVal(rs.getString("c1.cname"));
                teacher.setTclassVal2(rs.getString("c2.cname"));
                teachers.add(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps, rs);
        }

        return teachers;
    }

    @Override
    public int addTea(Teacher teacher) {
        int addCount = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBCommon.getConnection();
            String sql = "insert into teacher(tid, tname, tpwd, t_class, t_class2) values(?, ?, ?, ?, ?)";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setString(1, teacher.getTid());
            ps.setString(2, teacher.getTname());
            ps.setString(3, teacher.getTpwd());
            ps.setInt(4, teacher.getTclass());
            ps.setInt(5, teacher.getTclass2());
            addCount = DBCommon.executeUpdateBySql(ps);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps);
        }

        return addCount;
    }

    @Override
    public int deleteTea(int id) {
        int deleteCount = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBCommon.getConnection();
            String sql = "delete from teacher where id=?";
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

    @Override
    public Teacher getTea(int id) {
        Teacher teacher = new Teacher();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBCommon.getConnection();
            String sql = "SELECT t.id, t.tid, t.tname, t.tpwd, c1.cname, c2.cname FROM teacher t LEFT JOIN class c1 " +
                    "ON t.t_class = c1.cid LEFT JOIN class c2 ON t.t_class2 = c2.cid where id = ?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setInt(1, id);
            rs = DBCommon.getResultSet(ps);
            while (rs.next()) {
                teacher.setId(rs.getInt("t.id"));
                teacher.setTid(rs.getString("t.tid"));
                teacher.setTname(rs.getString("t.tname"));
                teacher.setTpwd(rs.getString("t.tpwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps, rs);
        }

        return teacher;
    }

    @Override
    public int updateTea(Teacher teacher) {
        int updateCount = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBCommon.getConnection();
            String sql = "update teacher set tid = ?, tname = ?, tpwd = ?, t_class = ? , t_class2 = ? where id = ?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setString(1, teacher.getTid());
            ps.setString(2, teacher.getTname());
            ps.setString(3, teacher.getTpwd());
            ps.setInt(4, teacher.getTclass());
            ps.setInt(5, teacher.getTclass2());
            ps.setInt(6, teacher.getId());
            updateCount = DBCommon.executeUpdateBySql(ps);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps);
        }

        return updateCount;
    }
}
