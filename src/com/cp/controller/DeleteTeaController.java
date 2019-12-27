package com.cp.controller;

import com.cp.service.impl.TeacherModuleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteTeaController", urlPatterns = "/deleteTea")

public class DeleteTeaController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id") == "" ? "0" : req.getParameter("id"));
        int deleteCount = 0;
        TeacherModuleServiceImpl tmsi = new TeacherModuleServiceImpl();

        if (id > 0) {
            deleteCount = tmsi.deleteTea(id);
            if (deleteCount > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }

        resp.sendRedirect(req.getContextPath() + "/findTeaAll");
    }
}
