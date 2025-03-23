package com.ramenenjoyer69.homework002.service.implement;

import com.ramenenjoyer69.homework002.model.entity.Student;
import com.ramenenjoyer69.homework002.model.request.StudentRequest;
import com.ramenenjoyer69.homework002.model.response.Response;
import com.ramenenjoyer69.homework002.repository.StudentCourseRepository;
import com.ramenenjoyer69.homework002.service.StudentService;
import com.ramenenjoyer69.homework002.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentCourseRepository studentCourseRepository) {
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public ResponseEntity<Response<List<Student>>> getAllStudent(Integer page, Integer size) {
        int offset = (page - 1) * size;
        List<Student> students = studentRepository.getAllStudents(offset, size);

        String message = students.isEmpty() ? "No students found" : "All students have been retrieved successfully";

        Response<List<Student>> response = new Response<>(
                message,
                students,
                HttpStatus.OK.value(),
                Instant.now()
        );

        return ResponseEntity.ok(response);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public Student saveStudent(StudentRequest request) {
        Student student = studentRepository.saveStudent(request);
        for (Long courseId : request.getCoursesId()) {
            studentCourseRepository.insertStudentIdAndCourseId(student.getStudentId(), courseId);
        }
        return studentRepository.getStudentById(student.getStudentId());
    }

    @Override
    public Student updateStudentById(Long studentId, StudentRequest request) {
        Student student = studentRepository.updateStudentById(studentId, request);

        List<Long> existingCourseIds = studentCourseRepository.getCourseIdsByStudentId(studentId);
        List<Long> newCourseIds = request.getCoursesId();

        // remove courses that are not in the new list
        for (Long existingCourseId : existingCourseIds ) {
            if (!newCourseIds.contains(existingCourseId)) {
                studentCourseRepository.removeStudentCourse(student.getStudentId(), existingCourseId);
            }
        }

        // adds the new courses that weren't present in the old list or existing list or whatever you wanna call it ig
        for (Long newCourseId : newCourseIds) {
            if (!existingCourseIds.contains(newCourseId)) {
                studentCourseRepository.insertStudentIdAndCourseId(student.getStudentId(), newCourseId);
            }
        }

        return studentRepository.getStudentById(student.getStudentId());
    }

    @Override
    public Student deleteStudentById(Long studentId) {
        return studentRepository.deleteStudentById(studentId);
    }


}
