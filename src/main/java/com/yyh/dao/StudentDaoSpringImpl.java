package com.yyh.dao;

import com.yyh.po.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.lang.model.SourceVersion;
import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-11-22-12:10
 */
@Repository
public class StudentDaoSpringImpl implements StudentDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Student> selectAll() {
        System.out.println("sessionFactory = " + sessionFactory);
        //1.获取session
        Session session = sessionFactory.openSession();
        //2.创建query对象
        Query query = session.createQuery("from Student");
        //3.执行查询
        return query.list();
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Student selectOne(int id) {
        return null;
    }

    @Override
    public boolean insertOrUpdate(Student student) {
        return false;
    }
}
