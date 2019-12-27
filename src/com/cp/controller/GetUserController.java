package com.cp.controller;

import com.cp.model.Student;
import com.cp.model.User;
import com.cp.service.impl.StudentModuleServiceImpl;
import com.cp.service.impl.UserModuleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetUserController", urlPatterns = "/getUser")

public class GetUserController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id") == "" ? "0" : req.getParameter("id"));

        UserModuleServiceImpl umsi = new UserModuleServiceImpl();
        User user = umsi.getUser(id);
        req.setAttribute("ut", user);
        req.getRequestDispatcher("/updateUser.jsp").forward(req, resp);
    }
}
