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

@WebServlet(name = "UpdateUserController", urlPatterns = "/updateUser")

public class UpdateUserController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = req.getParameter("id") == "" ? 0 : Integer.valueOf(req.getParameter("id"));
        String uid = req.getParameter("uid") == "" ? "null" : req.getParameter("uid");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserModuleServiceImpl umsi = new UserModuleServiceImpl();
        int updateCount = 0;
        if (uid != null) {
            updateCount = umsi.updateUser(new User(id, uid, username, password));
            if (updateCount > 0) {
                resp.getWriter().println("修改成功");
                System.out.println("修改成功");
            } else {
                resp.getWriter().println("修改失败");
                System.out.println("修改失败");
            }
        }

        resp.sendRedirect(req.getContextPath() + "/findUserAll");
    }
}
