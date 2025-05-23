package com.ramenenjoyer69.homework002.repository;

import com.ramenenjoyer69.homework002.model.entity.Student;
import com.ramenenjoyer69.homework002.model.request.StudentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Results( id = "studentMapper" , value =
            {
                    @Result(property = "studentId", column = "student_id"),
                    @Result(property = "studentName", column = "student_name"),
                    @Result(property = "phoneNumber", column = "phone_number"),
                    @Result(property = "courses", column = "student_id", many = @Many(select = "com.ramenenjoyer69.homework002.repository.StudentCourseRepository.getAllCoursesByStudentId")),

            }
    )
    @Select("""
        SELECT * FROM students
        OFFSET #{offset} LIMIT #{size}
    """)
    List<Student> getAllStudents(int offset, Integer size);


    @ResultMap("studentMapper")
    @Select("""
        SELECT * FROM students where student_id = #{studentId}
    """)
    Student getStudentById(Long studentId);

    @ResultMap("studentMapper")
    @Select("""
        INSERT INTO students VALUES (default, #{req.studentName},#{req.email} , #{req.phoneNumber}) RETURNING *
    """)
    Student saveStudent(@Param("req") StudentRequest request);

    @ResultMap("studentMapper")
    @Select("""
        UPDATE students set student_name = #{req.studentName}, email = #{req.email},phone_number = #{req.phoneNumber} where student_id = #{studentId} RETURNING *
    """)
    Student updateStudentById(Long studentId, @Param("req") StudentRequest request);


    @Select("""
        DELETE from students where student_id = #{studentId}
    """)
    Student deleteStudentById(Long studentId);



}
