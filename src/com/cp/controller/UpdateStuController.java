package com.cp.controller;

import com.cp.model.Student;
import com.cp.service.impl.StudentModuleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateStuController", urlPatterns = "/updateStu")

public class UpdateStuController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = req.getParameter("id") == "" ? 0 : Integer.valueOf(req.getParameter("id"));
        String sid = req.getParameter("sid") == "" ? "null" : req.getParameter("sid");
        String sname = req.getParameter("sname");
        String spwd = req.getParameter("spwd");
        int sclass = Integer.valueOf(req.getParameter("sclass"));
        StudentModuleServiceImpl smsi = new StudentModuleServiceImpl();
        int updateCount = 0;
        if (sid != null) {
            updateCount = smsi.updateStu(new Student(id, sid, sname, spwd, sclass));
            if (updateCount > 0) {
                resp.getWriter().println("修改成功");
                System.out.println("修改成功");
            } else {
                resp.getWriter().println("修改失败");
                System.out.println("修改失败");
            }
        }

        resp.sendRedirect(req.getContextPath() + "/findStuAll");
    }
}
