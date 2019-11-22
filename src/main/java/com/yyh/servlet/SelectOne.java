package com.yyh.servlet;

import com.yyh.dao.StudentDao;
import com.yyh.dao.StudentDaoImpl;
import com.yyh.po.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YanYuHang
 * @create 2019-11-22-10:09
 */
@WebServlet("/selectOne")
public class SelectOne extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao sd = new StudentDaoImpl();
        int id = Integer.valueOf(request.getParameter("id"));
        Student student = sd.selectOne(id);
        request.setAttribute("stu", student);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
