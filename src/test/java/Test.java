import com.yyh.po.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

/**
 * @author YanYuHang
 * @create 2019-11-20-10:08
 */
public class Test {
    //会话工厂
    private SessionFactory sessionFactory;
    //会话
    private Session session;
    //事务
    private Transaction tx;

    @org.junit.Before
    public void before() {
        //加载配置文件  configure() 方法  参数   hibernate配置文件的路径
        //如果不写  默认 classpath:hibernate.cfg.xml
        //如果写   就会找自定义路径
        Configuration configure = new Configuration().configure();
        //创建会话工厂
        sessionFactory = configure.buildSessionFactory();
        //生产会话
        session = sessionFactory.openSession();
        //开启事务
        tx = session.beginTransaction();
    }

    /**
     * 测试  单条查询
     */
    @org.junit.Test
    public void testGet() {
        Student student = session.get(Student.class, 1);
        System.out.println("student = " + student);
    }
    @org.junit.Test
    public void testLoad() {
        Student student = session.load(Student.class, 1);
        System.out.println("student = " + student);
    }

    /**
     * 增加操作
     */
    @org.junit.Test
    public void testInsert() {
        Student stu =new Student();
        stu.setStuName("王五");
        session.save(stu);
    }
    /**
     * 删除操作
     */
    @org.junit.Test
    public void testDelete() {
        //删除  先根据id查询是否存在对象(entity)  再去删除
        Student stu=session.get(Student.class,5);
        if(stu!=null){
            session.delete(stu);
        }
    }
    /**
     * 修改操作
     */
    @org.junit.Test
    public void testUpdate() {
        Student student=new Student();
        student.setStuId(6);
        student.setStuName("哈哈");
        session.update(student);
    }

    /**
     * 新增 或是  修改
     *   根据 实体类中的 主键  进行查询
     *   如果 查询到数据  那么执行 修改操作
     *   否则               执行 添加操作
     */
    @org.junit.Test
    public void testSaveOrUpdate() {
        Student student=new Student();
        student.setStuName("哈哈123");
        session.saveOrUpdate(student);
    }
    @org.junit.After
    public void after() {
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
