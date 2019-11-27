package com.yyh.dao;

import com.yyh.po.Student;
import com.yyh.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-11-21-11:00
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectAll() {
        //1.获取session
        Session session = HibernateUtils.getSession();
        //3.创建hql语句
        String hql = "from com.yyh.po.Student";
        Query query = session.createQuery(hql);
        //4.进行查询
        List<Student> list = query.list();
        //5.关闭
        session.close();
        return list;
    }

    @Override
    public boolean delete(int id) {
        //1.获取session
        Session session = HibernateUtils.getSession();
        //2.开启事务
        Transaction tx = session.beginTransaction();
        //2.根据id查询 查询结果不为空   就执行删除操作
        try {
            Student student = session.get(Student.class, id);
            //3.执行删除操作
            session.delete(student);
            //4.提交
            tx.commit();
            //5.关闭
            return true;

        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public Student selectOne(int id) {
        //1.获取session
        //Session session = HibernateUtils.getSession();
        //2.调用方法
        return HibernateUtils.getSession().get(Student.class, id);
    }

    @Override
    public boolean insertOrUpdate(Student student) {
        //1.获取session
        Session session = HibernateUtils.getSession();
        //2.开启事务
        Transaction tx = session.beginTransaction();
        //3.执行操作
        try {
            session.saveOrUpdate(student);
            tx.commit();
            return true;
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }

    }

}
