package com.cp.controller;

import com.cp.model.Student;
import com.cp.service.impl.StudentModuleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginStudentController", urlPatterns = "/loginStudent")

public class LoginStudentController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String sid = req.getParameter("username");
        String spwd = req.getParameter("password");
        Student student = new Student(sid, spwd);

        StudentModuleServiceImpl smsi = new StudentModuleServiceImpl();
        Student s = smsi.loginStudent(sid, spwd);

        if (s != null) {
            if (s.getSid() != null) {
                System.out.println(sid + spwd);
                HttpSession session = req.getSession();
                session.setAttribute("student", student);
                resp.sendRedirect(req.getContextPath() + "/findStu");
            } else {
                resp.getWriter().println("账号或密码错误");
                resp.setHeader("refresh", "3;url=" + req.getContextPath() + "/login.jsp");
            }
        } else {
            resp.getWriter().println("账号或密码错误");
            resp.setHeader("refresh", "3;url=" + req.getContextPath() + "/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
