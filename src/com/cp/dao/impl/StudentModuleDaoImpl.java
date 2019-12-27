package com.cp.dao.impl;

import com.cp.dao.StudentModuleDao;
import com.cp.model.Student;
import com.cp.util.DBCommon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentModuleDaoImpl implements StudentModuleDao {

    @Override
    public Student loginStudent(String sid, String spwd) {
        Student student = null;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBCommon.getConnection();
            String sql = "select * from student where sid = ? and spwd = ?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setString(1, sid);
            ps.setString(2, spwd);
            rs = DBCommon.getResultSet(ps);
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setSid(rs.getString("sid"));
                student.setSname(rs.getString("sname"));
                student.setSpwd(rs.getString("spwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps, rs);
        }

        return student;
    }

    @Override
    public List<Student> findStuAll() {
        List<Student> students = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBCommon.getConnection();
            String sql = "SELECT s.id, s.sid, s.sname, c.cname FROM student s LEFT JOIN class c ON s.s_class = c.cid";
            ps = DBCommon.getPreparedStatement(sql, con);
            rs = DBCommon.getResultSet(ps);
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("s.id"));
                student.setSid(rs.getString("s.sid"));
                student.setSname(rs.getString("s.sname"));
                student.setSclassVal(rs.getString("c.cname"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps, rs);
        }

        return students;
    }

    @Override
    public Student getStu(int id) {
        Student student = new Student();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBCommon.getConnection();
            String sql = "SELECT s.id, s.sid, s.sname, s.spwd, c.cname " +
                    "FROM student s LEFT JOIN class c ON s.s_class = c.cid where id = ?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setInt(1, id);
            rs = DBCommon.getResultSet(ps);
            while (rs.next()) {
                student.setId(rs.getInt("s.id"));
                student.setSid(rs.getString("s.sid"));
                student.setSname(rs.getString("s.sname"));
                student.setSpwd(rs.getString("s.spwd"));
//                student.setSclassVal(rs.getString("c.cname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps, rs);
        }

        return student;
    }

    @Override
    public Student getStu2(String sid) {
        Student student = new Student();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBCommon.getConnection();
            String sql = "SELECT s.id, s.sid, s.sname, c.cname, g.chinese, g.math, g.english FROM " +
                    "student s LEFT JOIN grade g ON s.s_grade = g.gid LEFT JOIN class c ON s.s_class = c.cid where " +
                    "s.sid = ?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setString(1, sid);
            rs = DBCommon.getResultSet(ps);
            while (rs.next()) {
                student.setId(rs.getInt("s.id"));
                student.setSid(rs.getString("s.sid"));
                student.setSname(rs.getString("s.sname"));
                student.setSclassVal(rs.getString("c.cname"));
                student.setChinese(rs.getDouble("g.chinese"));
                student.setMath(rs.getDouble("g.math"));
                student.setEnglish(rs.getDouble("g.english"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps, rs);
        }

        return student;
    }

    @Override
    public int updateStu(Student student) {
        int updateCount = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBCommon.getConnection();
            String sql = "update student set sid = ?, sname = ?, spwd = ?, s_class = ? where id = ?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setString(1, student.getSid());
            ps.setString(2, student.getSname());
            ps.setString(3, student.getSpwd());
            ps.setInt(4, student.getSclass());
            ps.setInt(5, student.getId());
            updateCount = DBCommon.executeUpdateBySql(ps);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps);
        }

        return updateCount;
    }

    @Override
    public int deleteStu(int id) {
        int deleteCount = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBCommon.getConnection();
            String sql = "delete from student where id=?";
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
    public int addStu(Student student) {
        int addCount = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBCommon.getConnection();
            String sql = "insert into student(sid, sname, spwd, s_class, s_grade) values(?, ?, ?, ?, ?)";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setString(1, student.getSid());
            ps.setString(2, student.getSname());
            ps.setString(3, student.getSpwd());
            ps.setInt(4, student.getSclass());
            ps.setInt(5, student.getSgrade());
            addCount = DBCommon.executeUpdateBySql(ps);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps);
        }

        return addCount;
    }

    @Override
    public int addStu2(Student student) {
        int addCount = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBCommon.getConnection();
            String sql = "insert into grade(gid) values(?)";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setInt(1, student.getSgrade());
            addCount = DBCommon.executeUpdateBySql(ps);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps);
        }

        return addCount;
    }

    @Override
    public List<Student> findStuGradeAll() {
        List<Student> students = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBCommon.getConnection();
            String sql = "SELECT s.id, s.sid, s.sname, s.s_grade, c.cname, g.chinese, g.math, g.english FROM " +
                    "student s LEFT JOIN grade g ON s.s_grade = g.gid LEFT JOIN class c ON s.s_class = c.cid";
            ps = DBCommon.getPreparedStatement(sql, con);
            rs = DBCommon.getResultSet(ps);
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("s.id"));
                student.setSid(rs.getString("s.sid"));
                student.setSname(rs.getString("s.sname"));
                student.setSclassVal(rs.getString("c.cname"));
                student.setChinese(rs.getDouble("g.chinese"));
                student.setMath(rs.getDouble("g.math"));
                student.setEnglish(rs.getDouble("g.english"));
                student.setSgrade(rs.getInt("s.s_grade"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps, rs);
        }

        return students;
    }

    @Override
    public int updateStuGrade(Student student) {
        int updateCount = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBCommon.getConnection();
            String sql = "UPDATE student s, grade g SET g.chinese = ?, g.math = ?, g.english = ? " +
                    "WHERE s.id = ? AND g.gid = ?";
            ps = DBCommon.getPreparedStatement(sql, con);
            ps.setDouble(1, student.getChinese());
            ps.setDouble(2, student.getMath());
            ps.setDouble(3, student.getEnglish());
            ps.setInt(4, student.getId());
            ps.setInt(5, student.getSgrade());
            updateCount = DBCommon.executeUpdateBySql(ps);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCommon.close(con, ps);
        }

        return updateCount;
    }

}
