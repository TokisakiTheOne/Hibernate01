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
@WebServlet("/insert")
public class Insert extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao sd = new StudentDaoImpl();
        String name = request.getParameter("stuName");
        Student student = new Student();
        student.setStuName(name);
        if (sd.insertOrUpdate(student)) {
            response.getWriter().print("<script>alert('添加成功');location.href='selectAll';</script>");
        } else {
            response.getWriter().print("<script>alert('添加失败');location.href='selectAll';</script>");

        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
