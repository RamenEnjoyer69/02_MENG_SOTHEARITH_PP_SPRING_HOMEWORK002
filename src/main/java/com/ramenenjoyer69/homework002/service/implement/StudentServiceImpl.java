package com.ramenenjoyer69.homework002.service.implement;

import com.ramenenjoyer69.homework002.model.entity.Student;
import com.ramenenjoyer69.homework002.model.request.StudentRequest;
import com.ramenenjoyer69.homework002.service.StudentService;
import com.ramenenjoyer69.homework002.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public Student saveStudent(StudentRequest request) {
        return studentRepository.saveStudent(request);
    }

    @Override
    public Student updateStudentById(Long studentId, StudentRequest request) {
        return studentRepository.updateStudentById(studentId, request);
    }

    @Override
    public Student deleteStudentById(Long studentId) {
        return studentRepository.deleteStudentById(studentId);
    }


}
