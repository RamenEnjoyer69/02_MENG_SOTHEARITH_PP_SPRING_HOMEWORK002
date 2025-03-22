package com.ramenenjoyer69.homework002.service.implement;

import com.ramenenjoyer69.homework002.model.entity.Course;
import com.ramenenjoyer69.homework002.model.request.CourseRequest;
import com.ramenenjoyer69.homework002.repository.CourseRepository;
import com.ramenenjoyer69.homework002.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses(Integer page, Integer size) {
        int offset = (page - 1) * size;
        return courseRepository.getAllCourses(offset, size);
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
