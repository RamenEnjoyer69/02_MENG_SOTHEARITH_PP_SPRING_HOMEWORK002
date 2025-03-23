package com.ramenenjoyer69.homework002.service.implement;

import com.ramenenjoyer69.homework002.model.entity.Course;
import com.ramenenjoyer69.homework002.model.request.CourseRequest;
import com.ramenenjoyer69.homework002.model.response.Response;
import com.ramenenjoyer69.homework002.repository.CourseRepository;
import com.ramenenjoyer69.homework002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public ResponseEntity<Response<List<Course>>> getAllCourses(Integer page, Integer size) {
        int offset = (page - 1) * size;
        List<Course> courses = courseRepository.getAllCourses(offset, size);

        String message = courses.isEmpty() ? "No courses found" : "All courses have been retrieved successfully";

        Response<List<Course>> response = new Response<>(
                message,
                courses,
                HttpStatus.OK.value(),
                Instant.now()
        );

        return ResponseEntity.ok(response);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public Course deleteCourseById(Long courseId) {
        return courseRepository.deleteCourseById(courseId);
    }

    @Override
    public Course saveCourse(CourseRequest request) {
        return courseRepository.saveCourse(request);
    }

    @Override
    public Course updateCourseById(Long courseId, CourseRequest request) {
        return courseRepository.updateCourseById(courseId, request);
    }


}
