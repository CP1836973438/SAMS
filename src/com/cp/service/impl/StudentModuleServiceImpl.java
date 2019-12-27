package com.cp.service.impl;

import com.cp.dao.impl.StudentModuleDaoImpl;
import com.cp.model.Student;
import com.cp.service.StudentModuleService;

import java.util.List;

public class StudentModuleServiceImpl implements StudentModuleService {
    StudentModuleDaoImpl smdi = new StudentModuleDaoImpl();

    @Override
    public Student loginStudent(String sid, String spwd) {
        return smdi.loginStudent(sid, spwd);
    }

    @Override
    public List<Student> findStuAll() {
        return smdi.findStuAll();
    }

    @Override
    public Student getStu(int id) {
        return smdi.getStu(id);
    }

    @Override
    public Student getStu2(String sid) {
        return smdi.getStu2(sid);
    }

    @Override
    public int updateStu(Student student) {
        return smdi.updateStu(student);
    }

    @Override
    public int deleteStu(int id) {
        return smdi.deleteStu(id);
    }

    @Override
    public int addStu(Student student) {
        return smdi.addStu(student);
    }

    @Override
    public int addStu2(Student student) {
        return smdi.addStu2(student);
    }

    @Override
    public List<Student> findStuGradeAll() {
        return smdi.findStuGradeAll();
    }

    @Override
    public int updateStuGrade(Student student) {
        return smdi.updateStuGrade(student);
    }

}
