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
     *
     * @return
     */
    List<Student> selectAll();

    /**
     * 删除
     *
     * @param id
     * @return
     */
    boolean delete(int id);


    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Student selectOne(int id);


    /**
     * 增加 修改
     *
     * @param student
     * @return
     */
    boolean insertOrUpdate(Student student);


}
