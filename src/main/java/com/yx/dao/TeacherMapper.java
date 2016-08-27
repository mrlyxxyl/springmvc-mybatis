package com.yx.dao;

import com.yx.bean.Teacher;
import com.yx.bean.TeacherExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeacherMapper {
    int countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<Map<String, Object>> queryTeacherStudents();

    @Select("SELECT id, teacher_name FROM teacher WHERE teacher_name = #{name}")
    List<Map<String, Object>> queryTeacherByName(String name);

    @Select("SELECT t.teacher_name, s.student_name FROM teacher t, student s WHERE s.tid = t.id")
    List<Map<String, Object>> queryTS();
}