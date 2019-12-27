package com.cp.controller;

import com.cp.model.Student;
import com.cp.service.impl.StudentModuleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateStuGradeController", urlPatterns = "/updateStuGrade")

public class UpdateStuGradeController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = req.getParameter("id") == "" ? 0 : Integer.valueOf(req.getParameter("id"));
        String sid = req.getParameter("sid") == "" ? "null" : req.getParameter("sid");
        double chinese = req.getParameter("chinese") == "" ? 0 : Double.valueOf(req.getParameter("chinese"));
        double math = req.getParameter("math") == "" ? 0 : Double.valueOf(req.getParameter("math"));
        double english = req.getParameter("english") == "" ? 0 : Double.valueOf(req.getParameter("english"));
        int sgarde = req.getParameter("sgrade") == "" ? 0 : Integer.valueOf(req.getParameter("sgrade"));
        StudentModuleServiceImpl smsi = new StudentModuleServiceImpl();
        int updateCount = 0;
        if (id != 0) {
            updateCount = smsi.updateStuGrade(new Student(id, chinese, math, english, sgarde));
            if (updateCount > 0) {
                resp.getWriter().println("修改成功");
                System.out.println("修改成功");
            } else {
                resp.getWriter().println("修改失败");
                System.out.println("修改失败");
            }
        }

        resp.sendRedirect(req.getContextPath() + "/findStuGradeAll");
    }
}
