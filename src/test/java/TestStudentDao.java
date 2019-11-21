import com.yyh.dao.StudentDao;
import com.yyh.dao.StudentDaoImpl;
import com.yyh.po.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-11-20-10:08
 */
public class TestStudentDao {

    /**
     * 测试  单条查询
     */
    @org.junit.Test
    public void testStudentDaoSelectAll() {
        StudentDao sd = new StudentDaoImpl();
        List<Student> students =((StudentDaoImpl) sd).selectQueryAll();
        for (Student student : students) {
            System.out.println("student = " + student);
        }

    }
}
