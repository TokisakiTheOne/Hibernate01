package com.yyh.dao;

import com.yyh.po.Student;

import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-11-21-11:00
 */
public interface StudentDao {

    /**
     * 查询全部
     * @return
     */
    List<Student> selectAll();

}
