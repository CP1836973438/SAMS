package com.cp.service.impl;

import com.cp.dao.impl.TeacherModuleDaoImpl;
import com.cp.model.Teacher;
import com.cp.service.TeacherModuleService;

import java.util.List;

public class TeacherModuleServiceImpl implements TeacherModuleService {
    TeacherModuleDaoImpl tmdi = new TeacherModuleDaoImpl();

    @Override
    public Teacher loginTeacher(String tid, String tpwd) {
        return tmdi.loginTeacher(tid, tpwd);
    }

    @Override
    public List<Teacher> findTeaAll() {
        return tmdi.findTeaAll();
    }

    @Override
    public int addTea(Teacher teacher) {
        return tmdi.addTea(teacher);
    }

    @Override
    public int deleteTea(int id) {
        return tmdi.deleteTea(id);
    }

    @Override
    public Teacher getTea(int id) {
        return tmdi.getTea(id);
    }

    @Override
    public int updateTea(Teacher teacher) {
        return tmdi.updateTea(teacher);
    }
}
