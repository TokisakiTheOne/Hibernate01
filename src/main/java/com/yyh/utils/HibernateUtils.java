package com.yyh.utils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * hibernate工具类
 *
 * @author YanYuHang
 * @create 2019-11-21-11:04
 */
public class HibernateUtils {
    /**
     * 会话工厂
     */
    private static SessionFactory sessionFactory;
    static {
        //加载配置文件  configure() 方法  参数   hibernate配置文件的路径
        Configuration configure = new Configuration().configure();
        //创建会话工厂
        sessionFactory = configure.buildSessionFactory();

    }
    public static Session getSession() {
        Session session = sessionFactory.openSession();
        return session;
    }
}
