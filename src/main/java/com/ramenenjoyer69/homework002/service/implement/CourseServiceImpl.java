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
    public ResponseEntity<Response<Course>> getCourseById(Long courseId) {

        Course course = courseRepository.getCourseById(courseId);

        if (course == null) {
            Response<Course> response = new Response<>(
                    "Course not found",
                    null,
                    HttpStatus.NOT_FOUND.value(),
                    Instant.now()
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        Response<Course> response = new Response<>(
                "Course retrieved successfully",
                course,
                HttpStatus.OK.value(),
                Instant.now()
        );

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Course>> deleteCourseById(Long courseId) {

        Course course = courseRepository.getCourseById(courseId);

        if (course == null) {
            Response<Course> response = new Response<>(
                    "Course not found",
                    null,
                    HttpStatus.NOT_FOUND.value(),
                    Instant.now()
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        Course deletedCourse = courseRepository.deleteCourseById(courseId);
        Response<Course> response = new Response<>(
                "Course deleted successfully",
                deletedCourse,
                HttpStatus.OK.value(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @Override
    public ResponseEntity<Response<Course>> saveCourse(CourseRequest request) {

        Course course = courseRepository.saveCourse(request);

        Response<Course> response = new Response<>(
                "Course saved successfully",
                course,
                HttpStatus.CREATED.value(),
                Instant.now()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<Response<Course>> updateCourseById(Long courseId, CourseRequest request) {

        Course course = courseRepository.getCourseById(courseId);

        if (course == null) {
            Response<Course> response = new Response<>(
                    "Course not found",
                    null,
                    HttpStatus.NOT_FOUND.value(),
                    Instant.now()
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        Course updatedCourse = courseRepository.updateCourseById(courseId, request);
        Response<Course> response = new Response<>(
                "Course updated successfully",
                updatedCourse,
                HttpStatus.OK.value(),
                Instant.now()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
