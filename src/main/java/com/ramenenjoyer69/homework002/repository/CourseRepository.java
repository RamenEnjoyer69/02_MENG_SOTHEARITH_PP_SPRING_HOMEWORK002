package com.ramenenjoyer69.homework002.repository;

import com.ramenenjoyer69.homework002.model.entity.Course;
import com.ramenenjoyer69.homework002.model.request.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Results( id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id", one = @One(select = "com.ramenenjoyer69.homework002.repository.InstructorRepository.getInstructorById")),
    })
    @Select("""
        select * from courses
        OFFSET #{offset} LIMIT #{size}
    """)
    List<Course> getAllCourses(int offset, Integer size);


    @ResultMap("courseMapper")
    @Select("""
        select * from courses where course_id = #{courseId}
    """)
    Course getCourseById(Long courseId);


    @Select("""
        DELETE from courses where course_id = #{courseId}
    """)
    Course deleteCourseById(Long courseId);

    @ResultMap("courseMapper")
    @Select("""
        INSERT INTO courses values (default, #{req.courseName}, #{req.description}, #{req.instructorId}) returning *
    """)
    Course saveCourse(@Param("req") CourseRequest request);


    @ResultMap("courseMapper")
    @Select("""
        UPDATE courses set course_name = #{req.courseName},description = #{req.description} , instructor_id = #{req.instructorId} where course_id = #{courseId} returning *
    """)
    Course updateCourseById(Long courseId, @Param("req") CourseRequest request);
}
