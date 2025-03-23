package com.ramenenjoyer69.homework002.service;

import com.ramenenjoyer69.homework002.model.entity.Course;
import com.ramenenjoyer69.homework002.model.request.CourseRequest;
import com.ramenenjoyer69.homework002.model.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {
    ResponseEntity<Response<List<Course>>> getAllCourses(Integer page, Integer size);

    Course getCourseById(Long courseId);

    ResponseEntity<Response<Course>> deleteCourseById(Long courseId);

    ResponseEntity<Response<Course>> saveCourse(CourseRequest request);

    ResponseEntity<Response<Course>> updateCourseById(Long courseId, CourseRequest request);
}
