package com.yyh.dao;

import com.yyh.po.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-11-22-12:10
 */
@Repository
public class StudentDaoSpringImpl implements StudentDao {

    @Resource
    SessionFactory sessionFactory;

    public List<Student> selectAll() {
        System.out.println(sessionFactory.openSession());
        //1.获取session
        Session session = sessionFactory.openSession();
        //2.创建query对象
        Query query = session.createQuery("from Student");
        //3.执行查询
        List<Student> list = query.list();
        return list;
    }

    public boolean delete(int id) {
        return false;
    }

    public Student selectOne(int id) {
        return null;
    }

    public boolean insertOrUpdate(Student student) {
        return false;
    }
}
