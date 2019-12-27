package com.cp.controller;

import com.cp.model.Student;
import com.cp.service.impl.StudentModuleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetStuController", urlPatterns = "/getStu")

public class GetStuController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id") == "" ? "0" : req.getParameter("id"));

        StudentModuleServiceImpl smsi = new StudentModuleServiceImpl();
        Student student = smsi.getStu(id);
        req.setAttribute("st", student);
        req.getRequestDispatcher("/updateStu.jsp").forward(req, resp);
    }
}
