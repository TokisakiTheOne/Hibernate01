package com.yyh.dao;

import com.yyh.po.Student;
import com.yyh.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-11-21-11:00
 */
public class StudentDaoImpl implements StudentDao {

    public List<Student> selectAll() {
        //1.获取session
        Session session = HibernateUtils.getSession();
        //2.创建hql语句
        String hql = "from com.yyh.po.Student";
        //3.创建query对象
        Query query = session.createQuery(hql);
        //4.进行查询
        List<Student> list = query.list();
        //5.关闭
        HibernateUtils.closeSession();
        return list;
    }

    public List<Student> selectQueryAll() {
        //1.创建hql语句
        String hql = "from com.yyh.po.Student";
        //2.创建query对象
        Query query =HibernateUtils.getQuery(hql);
        //3.进行查询
        List<Student> list = query.list();
        //4.关闭
        HibernateUtils.closeSession();
        return list;
    }
}
