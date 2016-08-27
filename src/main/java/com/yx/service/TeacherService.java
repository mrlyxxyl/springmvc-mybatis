package com.yx.service;


import com.yx.bean.Teacher;
import com.yx.bean.TeacherExample;
import com.yx.dao.TeacherMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private JdbcTemplate jdbcTemplate;

    public int addTeacher(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    public List<Teacher> queryAllTeachers() {
        return teacherMapper.selectByExample(new TeacherExample());
    }

    public Teacher queryTeacherById(Integer teacherId) {
        return teacherMapper.selectByPrimaryKey(teacherId);
    }

    public List<Map<String, Object>> queryTeacherStudents() {
        return teacherMapper.queryTeacherStudents();
    }

    public List<Map<String, Object>> queryTeacherByName(String name) {
        return teacherMapper.queryTeacherByName(name);
    }

    public List<Map<String, Object>> queryTS() {
        return teacherMapper.queryTS();
    }
}
