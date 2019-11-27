package com.yyh.dao;

import com.yyh.po.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.lang.model.SourceVersion;
import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-11-22-12:10
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class StudentDaoSpringImpl implements StudentDao {

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    public List<Student> selectAll() {
        return hibernateTemplate.loadAll(Student.class);
    }

    @Override
    public boolean delete(int id) {
        try {
            hibernateTemplate.bulkUpdate("delete from Student where id=?",id);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Student selectOne(int id) {
        return hibernateTemplate.get(Student.class, id);
    }

    @Override
    public boolean insertOrUpdate(Student student) {
        try {
            hibernateTemplate.saveOrUpdate(student);
/*
            hibernateTemplate.flush();
*/
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
