package com.ramenenjoyer69.homework002.service;

import com.ramenenjoyer69.homework002.model.entity.Instructor;
import com.ramenenjoyer69.homework002.model.request.InstructorRequest;
import com.ramenenjoyer69.homework002.model.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InstructorService {


    ResponseEntity<Response<List<Instructor>>> getAllInstructors(Integer page, Integer size);

    ResponseEntity<Response<Instructor>> saveInstructor(InstructorRequest request);

    ResponseEntity<Response<Instructor>> getInstructorById(Long instructor_id);


    Instructor updateInstructorById(Long instructorId, InstructorRequest request);

    Instructor deleteInstructorById(Long instructorId);
}
