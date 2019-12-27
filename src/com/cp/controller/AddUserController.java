package com.cp.controller;

import com.cp.dao.impl.UserModuleDaoImpl;
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

@WebServlet(name = "AddUserController", urlPatterns = "/addUser")

public class AddUserController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String uid = req.getParameter("uid");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserModuleServiceImpl umsi = new UserModuleServiceImpl();
        int addCount = umsi.addUser(new User(uid, username, password));

        if (addCount > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

        resp.sendRedirect(req.getContextPath() + "/findUserAll");
    }
}
