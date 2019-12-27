package com.cp.controller;

import com.cp.model.Student;
import com.cp.model.Teacher;
import com.cp.service.impl.StudentModuleServiceImpl;
import com.cp.service.impl.TeacherModuleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddTeaController", urlPatterns = "/addTea")

public class AddTeaController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String tid = req.getParameter("tid");
        String tname = req.getParameter("tname");
        String tpwd = req.getParameter("tpwd");
        int tclass = Integer.valueOf(req.getParameter("tclass"));
        int tclass2 = Integer.valueOf(req.getParameter("tclass2"));

        TeacherModuleServiceImpl tmsi = new TeacherModuleServiceImpl();
        int addCount = tmsi.addTea(new Teacher(tid, tname, tpwd, tclass, tclass2));

        if (addCount > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

        resp.sendRedirect(req.getContextPath() + "/findTeaAll");
    }
}
