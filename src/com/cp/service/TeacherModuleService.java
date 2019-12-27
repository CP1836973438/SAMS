package com.cp.service;

import com.cp.model.Teacher;

import java.util.List;

public interface TeacherModuleService {

    public Teacher loginTeacher(String tid, String tpwd);

    public List<Teacher> findTeaAll();

    public int addTea(Teacher teacher);

    public int deleteTea(int id);

    public Teacher getTea(int id);

    public int updateTea(Teacher teacher);

}
