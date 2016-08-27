package com.yx.dao;

import com.yx.bean.Student;
import com.yx.bean.StudentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Map<String, Object>> queryTeacherStudents();

    Student queryStudentByIdAndName(Integer studentId, String name);

    Student queryStudentByIdAndNameAnnotation(@Param("studentId") Integer studentId, @Param("name") String name);//@Param不能去，即使一样

    List<Map<String, Object>> callPro();

    List<Map<String, Object>> qStudents();

    List<Map<String, Object>> queryStudents();

    Map<String, Object> queryStudentMap(Integer sid);

    void dynamicSql(Student student);
}