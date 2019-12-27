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

@WebServlet(name = "GetTeaController", urlPatterns = "/getTea")

public class GetTeaController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id") == "" ? "0" : req.getParameter("id"));

        TeacherModuleServiceImpl tmsi = new TeacherModuleServiceImpl();
        Teacher teacher = tmsi.getTea(id);
        req.setAttribute("tt", teacher);
        req.getRequestDispatcher("/updateTea.jsp").forward(req, resp);
    }
}
