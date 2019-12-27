package com.cp.controller;

import com.cp.model.Student;
import com.cp.service.impl.StudentModuleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddStuController", urlPatterns = "/addStu")

public class AddStuController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String sid = req.getParameter("sid");
        String sname = req.getParameter("sname");
        String spwd = req.getParameter("spwd");
        int sclass = Integer.valueOf(req.getParameter("sclass"));
        int sgrade = Integer.valueOf(sid.substring(sid.length() - 7, sid.length()));

        StudentModuleServiceImpl smsi = new StudentModuleServiceImpl();

        int addCount2 = smsi.addStu2(new Student(sgrade));
        int addCount = smsi.addStu(new Student(sid, sname, spwd, sclass, sgrade));

        if (addCount2 > 0) {
            if (addCount > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } else {
            System.out.println("添加失败");
        }

        resp.sendRedirect(req.getContextPath() + "/findStuAll");
    }
}
