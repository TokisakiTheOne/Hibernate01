package com.yyh.utils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * hibernate工具类
 * @author YanYuHang
 * @create 2019-11-21-11:04
 */
public class HibernateUtils {
    /**
     * 会话工厂
     */
    private static SessionFactory sessionFactory;
    /**
     * 会话
     */
    private static Session session;
    /**
     * 事务
     */
    private static Transaction tx;

    static {
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


    public static Session getSession() {
        return session;
    }

    public static Query getQuery(String hql){
        return session.createQuery(hql);
    }

    public static void closeSession() {
        tx.commit();
        session.close();
        sessionFactory.close();
    }


}
