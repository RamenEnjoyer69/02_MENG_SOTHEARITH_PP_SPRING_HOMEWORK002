package com.ramenenjoyer69.homework002.repository;

import com.ramenenjoyer69.homework002.model.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Results(
            {
                    @Result(property = "studentId", column = "student_id"),
                    @Result(property = "studentName", column = "student_name"),
                    @Result(property = "phoneNumber", column = "phone_number")
            }
    )
    @Select("""
        SELECT * FROM students
    """)
    List<Student> getAllStudents();
}
