package com.ramenenjoyer69.homework002.service;

import com.ramenenjoyer69.homework002.model.entity.Student;
import com.ramenenjoyer69.homework002.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();

    Student getStudentById(Long studentId);

    Student saveStudent(StudentRequest request);


    Student updateStudentById(Long studentId, StudentRequest request);

    Student deleteStudentById(Long studentId);
}
