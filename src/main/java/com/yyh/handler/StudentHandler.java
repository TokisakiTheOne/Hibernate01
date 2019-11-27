package com.yyh.handler;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yyh.dao.StudentDao;
import com.yyh.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-11-27-8:51
 */
@Controller
public class StudentHandler {
    @Autowired
    private StudentDao sd;
    //    SSH   Spring  Struts    Hibernate
    //NEW SSH   Spring  SpringMVC Hibernate
    @RequestMapping("/selectAll")
    public String selectAll(Model model) {
        model.addAttribute("list",sd.selectAll());
        return "index";
    }
}
