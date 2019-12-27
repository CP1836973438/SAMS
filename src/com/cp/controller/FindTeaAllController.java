package com.cp.controller;

import com.cp.model.Teacher;
import com.cp.service.impl.TeacherModuleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindTeaAllController", urlPatterns = "/findTeaAll")

public class FindTeaAllController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> teachers;

        TeacherModuleServiceImpl tmsi = new TeacherModuleServiceImpl();

        teachers = tmsi.findTeaAll();

        req.setAttribute("teachers", teachers);
        req.getRequestDispatcher("/teaMgt.jsp").forward(req, resp);
    }
}
