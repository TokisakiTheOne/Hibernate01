package com.yyh.po;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author YanYuHang
 * @create 2019-11-21-8:57
 */
@Entity
@Data
public class Student {
    private int stuId;
    private String stuName;

    @Id
    @Column(name = "stu_id", nullable = false)
    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "stu_name", nullable = false, length = 20)
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (stuId != student.stuId) return false;
        if (stuName != null ? !stuName.equals(student.stuName) : student.stuName != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = stuId;
        result = 31 * result + (stuName != null ? stuName.hashCode() : 0);
        return result;
    }
}
