package com.yx.controller;

import com.yx.bean.Teacher;
import com.yx.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @RequestMapping(value = "insert")
    @ResponseBody
    public Map<String, Object> insert() {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        Teacher teacher = new Teacher();
        teacher.setTeacherName("hello");
        teacherService.addTeacher(teacher);
        objectMap.put("record", teacher);
        objectMap.put("result", "success");
        return objectMap;
    }

    @RequestMapping(value = "queryAllTeachers")
    @ResponseBody
    public Map<String, Object> queryAllTeachers() {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        List<Teacher> teachers = teacherService.queryAllTeachers();
        objectMap.put("records", teachers);
        objectMap.put("result", "success");
        return objectMap;
    }

    @RequestMapping(value = "queryTeacherById")
    @ResponseBody
    public Map<String, Object> queryTeacherById(Integer teacherId) {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        Teacher teacher = teacherService.queryTeacherById(teacherId);
        objectMap.put("record", teacher);
        objectMap.put("result", "success");
        return objectMap;
    }

    /**
     * 一对多
     *
     * @return
     */
    @RequestMapping(value = "queryTeacherStudents")
    @ResponseBody
    public Map<String, Object> queryTeacherStudents() {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        List<Map<String, Object>> ts = teacherService.queryTeacherStudents();
        objectMap.put("records", ts);
        objectMap.put("result", "success");
        return objectMap;
    }

    /**
     * dao层采用注解
     *
     * @return
     */
    @RequestMapping(value = "queryTeacherByName")
    @ResponseBody
    public Map<String, Object> queryTeacherByName(String name) {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        List<Map<String, Object>> ts = teacherService.queryTeacherByName(name);
        objectMap.put("records", ts);
        objectMap.put("result", "success");
        return objectMap;
    }

    /**
     * dao层采用注解,联合查询
     *
     * @return
     */
    @RequestMapping(value = "queryTS")
    @ResponseBody
    public Map<String, Object> queryTS() {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        List<Map<String, Object>> ts = teacherService.queryTS();
        objectMap.put("records", ts);
        objectMap.put("result", "success");
        return objectMap;
    }
}
