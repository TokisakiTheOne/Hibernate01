package com.yyh.servlet;

import com.yyh.dao.StudentDao;
import com.yyh.dao.StudentDaoImpl;
import com.yyh.dao.StudentDaoSpringImpl;
import com.yyh.po.Student;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-11-22-8:37
 */
@WebServlet("/selectAll")
public class Servlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        StudentDao sd = new StudentDaoSpringImpl();
        List<Student> students = sd.selectAll();
        request.setAttribute("list", students);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
