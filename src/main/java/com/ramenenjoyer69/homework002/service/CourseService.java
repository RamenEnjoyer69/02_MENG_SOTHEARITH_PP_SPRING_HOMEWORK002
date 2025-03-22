package com.ramenenjoyer69.homework002.service;

import com.ramenenjoyer69.homework002.model.entity.Course;
import com.ramenenjoyer69.homework002.model.request.CourseRequest;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses(Integer page, Integer size);

    Course getCourseById(Long courseId);

    Course deleteCourseById(Long courseId);

    Course saveCourse(CourseRequest request);

    Course updateCourseById(Long courseId, CourseRequest request);
}
