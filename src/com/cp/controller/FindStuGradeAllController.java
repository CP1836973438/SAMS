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

@WebServlet(name = "FindStuGradeAllController", urlPatterns = "/findStuGradeAll")

public class FindStuGradeAllController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students;

        StudentModuleServiceImpl smsi = new StudentModuleServiceImpl();

        students = smsi.findStuGradeAll();

        req.setAttribute("students", students);
        req.getRequestDispatcher("/stuGradeMgt.jsp").forward(req, resp);
    }
}
