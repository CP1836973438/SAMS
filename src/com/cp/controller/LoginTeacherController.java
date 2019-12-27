package com.cp.controller;

import com.cp.model.Teacher;
import com.cp.service.impl.TeacherModuleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginTeacherController", urlPatterns = "/loginTeacher")

public class LoginTeacherController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String tid = req.getParameter("username");
        String tpwd = req.getParameter("password");

        TeacherModuleServiceImpl tmsi = new TeacherModuleServiceImpl();
        Teacher t = tmsi.loginTeacher(tid, tpwd);

        if (t != null) {
            if (t.getTid() != null) {
                System.out.println(tid + tpwd);
                HttpSession session = req.getSession();
                session.setAttribute("t", t);
                resp.sendRedirect(req.getContextPath() + "/indexTea.jsp");
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
