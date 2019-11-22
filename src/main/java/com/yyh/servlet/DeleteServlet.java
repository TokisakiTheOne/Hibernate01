package com.yyh.servlet;

import com.yyh.dao.StudentDao;
import com.yyh.dao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YanYuHang
 * @create 2019-11-22-9:08
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao sd = new StudentDaoImpl();
        int id = Integer.valueOf(request.getParameter("id"));
        if (sd.delete(id)) {
            response.getWriter().print("<script>alert('删除成功');location.href='selectAll';</script>");
        } else {
            response.getWriter().print("<script>alert('删除失败');location.href='selectAll';</script>");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
