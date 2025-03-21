package com.ramenenjoyer69.homework002.service;

import com.ramenenjoyer69.homework002.model.entity.Instructor;
import com.ramenenjoyer69.homework002.model.request.InstructorRequest;

import java.util.List;

public interface InstructorService {


    List<Instructor> getAllInstructors();

    Instructor saveInstructor(InstructorRequest request);

    Instructor getInstructorById(Long instructor_id);


    Instructor updateInstructorById(Long instructorId, InstructorRequest request);

    Instructor deleteInstructorById(Long instructorId);
}
