package com.ramenenjoyer69.homework002.controller;

import com.ramenenjoyer69.homework002.exception.NotFoundException;
import com.ramenenjoyer69.homework002.model.entity.Student;
import com.ramenenjoyer69.homework002.model.error.ErrorResponse;
import com.ramenenjoyer69.homework002.model.request.StudentRequest;
import com.ramenenjoyer69.homework002.model.response.Response;
import com.ramenenjoyer69.homework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Response<List<Student>>> getAllStudents(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return studentService.getAllStudent(page, size);
    }

    @GetMapping("/{student_id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long student_id) {

        Student student = studentService.getStudentById(student_id);

        try {
            if (student == null) {
                throw new NotFoundException("Student not found");
            }
        }
        catch (NotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(
                    e.getMessage(),
                    HttpStatus.NOT_FOUND
            );

            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response<Student>> saveStudent(@RequestBody StudentRequest request) {
        return studentService.saveStudent(request);
    }

    @PutMapping("/{student-id}")
    public ResponseEntity<Response<Student>> updateStudentById(@PathVariable("student-id") Long studentId, @RequestBody StudentRequest request) {
        return studentService.updateStudentById(studentId, request);
    }

    @DeleteMapping("/{student_id}")
    public ResponseEntity<Response<Student>> deleteStudentById(@PathVariable("student_id") Long studentId) {
        return studentService.deleteStudentById(studentId);
    }
}
