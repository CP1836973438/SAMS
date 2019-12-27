package com.cp.controller;

import com.cp.model.User;
import com.cp.service.impl.UserModuleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginUserController", urlPatterns = "/loginUser")

public class LoginUserController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uid = req.getParameter("username");
        String password = req.getParameter("password");

        UserModuleServiceImpl umsi = new UserModuleServiceImpl();
        User u = umsi.loginUser(uid, password);

        if (u != null) {
            if (u.getUid() != null) {
                System.out.println(uid + password);
                HttpSession session = req.getSession();
                session.setAttribute("u", u);
//                resp.getWriter().println("{\"status\": 000,\"statusText\": \"sss\"}");
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            } else {
                resp.setHeader("refresh", "3;url=" + req.getContextPath() + "/login.jsp");
            }
        } else {
            resp.setHeader("refresh", "3;url=" + req.getContextPath() + "/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
