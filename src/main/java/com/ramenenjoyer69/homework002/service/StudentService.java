package com.ramenenjoyer69.homework002.service;

import com.ramenenjoyer69.homework002.model.entity.Student;
import com.ramenenjoyer69.homework002.model.request.StudentRequest;
import com.ramenenjoyer69.homework002.model.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    ResponseEntity<Response<List<Student>>> getAllStudent(Integer page, Integer size);

    Student getStudentById(Long studentId);

    Student saveStudent(StudentRequest request);


    Student updateStudentById(Long studentId, StudentRequest request);

    Student deleteStudentById(Long studentId);
}
