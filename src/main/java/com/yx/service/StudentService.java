package com.yx.service;

import com.yx.bean.Student;
import com.yx.dao.StudentMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> queryTeacherStudents() {
        return studentMapper.queryTeacherStudents();
    }

    public Student queryStudentByIdAndName(Integer studentId, String name) {
        return studentMapper.queryStudentByIdAndNameAnnotation(studentId, name);//采用注解
//        return studentMapper.queryStudentByIdAndName(studentId, name); //采用参数顺序
    }

    public List<Map<String, Object>> callPro() {
        return studentMapper.callPro();
    }

    public List<Map<String, Object>> qStudents() {
        return studentMapper.qStudents();
    }

    public List<Map<String, Object>> queryStudents() {
        return studentMapper.queryStudents();
    }

    public Map<String, Object> queryStudentMap(Integer sid) {
        return studentMapper.queryStudentMap(sid);
    }

    public void dynamicSql(Student student) {
        studentMapper.dynamicSql(student);
    }
}
