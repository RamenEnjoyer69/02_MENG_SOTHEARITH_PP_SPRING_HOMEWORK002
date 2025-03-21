package com.ramenenjoyer69.homework002.repository;


import com.ramenenjoyer69.homework002.model.entity.Instructor;
import com.ramenenjoyer69.homework002.model.request.InstructorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepository {
    @Results( id = "instructorMapper", value = {
                    @Result(property = "instructorId", column = "instructor_id"),
                    @Result(property = "instructorName", column = "instructor_name"),
            }
    )
    @Select("""
        SELECT * FROM instructors
    """)
    List<Instructor> getAllInstructors();


    @ResultMap("instructorMapper")
    @Select("""
        INSERT INTO instructors VALUES (default, #{req.instructorName}, #{req.email})
        RETURNING *;
    """)
    Instructor saveInstructor(@Param("req") InstructorRequest request);


    @ResultMap("instructorMapper")
    @Select("""
        SELECT * FROM instructors where instructor_id = #{instructor_id}
    """)
    Instructor getInstructorById(Long instructor_id);


    @ResultMap("instructorMapper")
    @Select("""
        UPDATE instructors set instructor_name = #{req.instructorName}, email = #{req.email} Where instructor_id = #{instructorId} RETURNING *;
    """)
    Instructor updateInstructorById(Long instructorId, @Param("req") InstructorRequest request);


    @Select("""
        DELETE from instructors where instructor_id = #{instructor_id}
    """)
    Instructor deleteInstructorById(Long instructorId);
}
