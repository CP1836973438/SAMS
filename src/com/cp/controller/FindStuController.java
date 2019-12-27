package com.cp.controller;

import com.cp.model.Student;
import com.cp.service.impl.StudentModuleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindStuController", urlPatterns = "/findStu")

public class FindStuController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student students = (Student) req.getSession().getAttribute("student");
        System.out.println(students.getSid());
        String sid = students.getSid();

        StudentModuleServiceImpl smsi = new StudentModuleServiceImpl();

        Student student = smsi.getStu2(sid);

        req.setAttribute("student", student);
        req.getRequestDispatcher("/indexStu.jsp").forward(req, resp);
    }
}
