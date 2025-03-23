package com.ramenenjoyer69.homework002.service.implement;

import com.ramenenjoyer69.homework002.model.entity.Instructor;
import com.ramenenjoyer69.homework002.model.request.InstructorRequest;
import com.ramenenjoyer69.homework002.model.response.Response;
import com.ramenenjoyer69.homework002.repository.InstructorRepository;
import com.ramenenjoyer69.homework002.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public ResponseEntity<Response<List<Instructor>>> getAllInstructors(Integer page, Integer size) {
        int offset = (page - 1) * size;
        List<Instructor> instructors = instructorRepository.getAllInstructors(offset, size);

        String message = instructors.isEmpty() ? "No instructors found" : "All instructors have been successfully fetched.";

        Response<List<Instructor>> response = new Response<>(
                message,
                instructors,
                HttpStatus.OK.value(),
                Instant.now()
        );

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Instructor>> saveInstructor(InstructorRequest request) {

        Instructor instructor = instructorRepository.saveInstructor(request);

        String message = "Instructor saved successfully";
        Response<Instructor> response = new Response<>(
          message,
          instructor,
          HttpStatus.OK.value(),
          Instant.now()
        );

        return ResponseEntity.ok(response);
    }

    @Override
    public Instructor getInstructorById(Long instructor_id) {

        return instructorRepository.getInstructorById(instructor_id);
    }

    @Override
    public ResponseEntity<Response<Instructor>> updateInstructorById(Long instructorId, InstructorRequest request) {

        Instructor instructor = instructorRepository.updateInstructorById(instructorId, request);

        if (instructor == null) {
            Response<Instructor> response = new Response<>(
                    "Instructor not found",
                    null,
                    HttpStatus.NOT_FOUND.value(),
                    Instant.now()
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        Response<Instructor> response = new Response<>(
                "Instructor updated successfully",
                instructor,
                HttpStatus.OK.value(),
                Instant.now()
        );


        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<Response<Instructor>> deleteInstructorById(Long instructorId) {

        Instructor instructor = instructorRepository.getInstructorById(instructorId);
        if (instructor == null) {

            Response<Instructor> response = new Response<>(
                    "Instructor not found",
                    null,
                    HttpStatus.NOT_FOUND.value(),
                    Instant.now()
                    );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        Instructor deletedInstructor = instructorRepository.deleteInstructorById(instructorId);
        Response<Instructor> response = new Response<>(
                "Instructor deleted successfully",
                deletedInstructor,
                HttpStatus.OK.value(),
                Instant.now()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
