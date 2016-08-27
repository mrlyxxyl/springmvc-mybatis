package com.yx.controller;

import com.yx.bean.Student;
import com.yx.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "student")
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * 一对一
     *
     * @return
     */
    @RequestMapping(value = "queryTeacherStudents")
    @ResponseBody
    public Map<String, Object> queryTeacherStudents() {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        List<Map<String, Object>> ts = studentService.queryTeacherStudents();
        objectMap.put("records", ts);
        objectMap.put("result", "success");
        return objectMap;
    }

    /**
     * 传递多个参数
     *
     * @param studentId
     * @param name
     * @return
     */
    @RequestMapping(value = "queryStudentByIdAndName")
    @ResponseBody
    public Map<String, Object> queryStudentByIdAndName(Integer studentId, String name) {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        Student student = studentService.queryStudentByIdAndName(studentId, name);
        objectMap.put("record", student);
        objectMap.put("result", "success");
        return objectMap;
    }

    /**
     * 返回结果集 需要在mapper文件中的select 语句中 声明返回的数据类型为map类型
     *
     * @return
     */
    @RequestMapping(value = "callPro")
    @ResponseBody
    public Map<String, Object> callPro() {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        List<Map<String, Object>> records = studentService.callPro();
        objectMap.put("records", records);
        objectMap.put("result", "success");
        return objectMap;
    }

    /**
     * 用map来实现数据查询
     *
     * @return
     */
    @RequestMapping(value = "qStudents")
    @ResponseBody
    public Map<String, Object> qStudents() {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        List<Map<String, Object>> records = studentService.qStudents();
        objectMap.put("records", records);
        objectMap.put("result", "success");
        return objectMap;
    }

    /**
     * 用map来实现数据查询
     *
     * @return
     */
    @RequestMapping(value = "queryStudents")
    @ResponseBody
    public Map<String, Object> queryStudents() {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        List<Map<String, Object>> records = studentService.queryStudents();
        objectMap.put("records", records);
        objectMap.put("result", "success");
        return objectMap;
    }

    /**
     * 返回map数据
     *
     * @return
     */
    @RequestMapping(value = "queryStudentMap")
    @ResponseBody
    public Map<String, Object> queryStudentMap(int sid) {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        Map<String, Object> record = studentService.queryStudentMap(sid);
        objectMap.put("records", record);
        objectMap.put("result", "success");
        return objectMap;
    }

    /**
     * 返回map数据
     *
     * @return
     */
    @RequestMapping(value = "dynamicSql")
    @ResponseBody
    public Map<String, Object> dynamicSql(Student student) {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        studentService.dynamicSql(student);
        objectMap.put("result", "success");
        return objectMap;
    }
}
