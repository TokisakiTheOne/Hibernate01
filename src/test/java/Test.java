import com.yyh.dao.StudentDao;
import com.yyh.dao.StudentDaoImpl;
import com.yyh.po.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-11-20-10:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-hibernate.xml"})
public class Test {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private StudentDao sd;


    @org.junit.Test
    public void testGet() {
        //1.获取session
        Session session = sessionFactory.openSession();
        //2.创建query对象
        Query query = session.createQuery("from Student");
        //3.
        List<Student> list = query.list();

        list.forEach(System.out::println);

    }

    @org.junit.Test
    public void testSelectAll() {
        List<Student> list = sd.selectAll();
        list.forEach(System.out::println);
    }

    @org.junit.Test
    public void testInsert() {
        Student stu = new Student();
        stu.setStuId(20);
        stu.setStuName("admin123");
        //Serializable save = hibernateTemplate.save(stu);
        //增删改操作后必须要执行的方法
        sd.insertOrUpdate(stu);
    }


    @org.junit.Test
    public void testDao() {
        sd.delete(6);
    }

}
