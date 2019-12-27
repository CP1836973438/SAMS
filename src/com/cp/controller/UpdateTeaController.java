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

@WebServlet(name = "UpdateTeaController", urlPatterns = "/updateTea")

public class UpdateTeaController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = req.getParameter("id") == "" ? 0 : Integer.valueOf(req.getParameter("id"));
        String tid = req.getParameter("tid") == "" ? "null" : req.getParameter("tid");
        String tname = req.getParameter("tname");
        String tpwd = req.getParameter("tpwd");
        int tclass = Integer.valueOf(req.getParameter("tclass"));
        int tclass2 = Integer.valueOf(req.getParameter("tclass2"));
        TeacherModuleServiceImpl tmsi = new TeacherModuleServiceImpl();
        int updateCount = 0;
        if (tid != null) {
            updateCount = tmsi.updateTea(new Teacher(id, tid, tname, tpwd, tclass, tclass2));
            if (updateCount > 0) {
                resp.getWriter().println("修改成功");
                System.out.println("修改成功");
            } else {
                resp.getWriter().println("修改失败");
                System.out.println("修改失败");
            }
        }

        resp.sendRedirect(req.getContextPath() + "/findTeaAll");
    }
}
