package com.cp.dao;

import com.cp.model.Student;

import java.util.List;

public interface StudentModuleDao {

    public Student loginStudent(String sid, String spwd);

    public List<Student> findStuAll();

    public Student getStu(int id);

    public Student getStu2(String sid);

    public int updateStu(Student student);

    public int deleteStu(int id);

    public int addStu(Student student);

    public int addStu2(Student student);

    public List<Student> findStuGradeAll();

    public int updateStuGrade(Student student);

}
