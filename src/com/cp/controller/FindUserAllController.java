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
import java.util.List;

@WebServlet(name = "FindUserAllController", urlPatterns = "/findUserAll")

public class FindUserAllController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users;

        UserModuleServiceImpl umsi = new UserModuleServiceImpl();

        users = umsi.findUserAll();

        req.setAttribute("users", users);
        req.getRequestDispatcher("/userMgt.jsp").forward(req, resp);
    }
}
