package com.ramenenjoyer69.homework002.repository;

import com.ramenenjoyer69.homework002.model.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentCourseRepository {
    @Results(id = "studentCourseMapper", value = {

            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "course_id", many = @Many(select = "com.ramenenjoyer69.homework002.repository.InstructorRepository.getInstructorById")),
    })
    @Select("""
        SELECT * FROM student_course sc INNER JOIN courses c ON sc.course_id = c.course_id WHERE student_id = #{studentId}
    """)
    List<Course> getAllCoursesByStudentId(Long studentId);


    @Insert("""
         INSERT INTO student_course VALUES (default, #{studentId}, #{courseId})
     """)
    void insertStudentIdAndCourseId(Long studentId, Long courseId);

    @Select("SELECT course_id FROM student_course WHERE student_id = #{studentId}")
    List<Long> getCourseIdsByStudentId(Long studentId);

    @Delete("DELETE FROM student_course WHERE student_id = #{studentId} AND course_id = #{courseId}")
    void removeStudentCourse(Long studentId, Long courseId);

}
