package com.ramenenjoyer69.homework002.controller;


import com.ramenenjoyer69.homework002.exception.NotFoundException;
import com.ramenenjoyer69.homework002.model.entity.Instructor;
import com.ramenenjoyer69.homework002.model.error.ErrorResponse;
import com.ramenenjoyer69.homework002.model.request.InstructorRequest;
import com.ramenenjoyer69.homework002.model.response.Response;
import com.ramenenjoyer69.homework002.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;


    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<Response<List<Instructor>>> getAllInstructors(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {

        return instructorService.getAllInstructors(page, size);
    }

    @PostMapping
    public ResponseEntity<Response<Instructor>> saveInstructor(@RequestBody InstructorRequest request) {

        return instructorService.saveInstructor(request);
    }

    @GetMapping("/{instructor_id}")
    public ResponseEntity<?> getInstructorById(@PathVariable Long instructor_id) {
        Instructor instructor = instructorService.getInstructorById(instructor_id);

        try {
            if (instructor == null) {
                throw new NotFoundException("Instructor with the ID " + instructor_id +" not found");
            }
        } catch (NotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(
                    e.getMessage(),
                    HttpStatus.NOT_FOUND
            );

            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }

    @PutMapping("/{instructor-id}")
    public ResponseEntity<Response<Instructor>> updateInstructor(@PathVariable("instructor-id") Long instructorId, @RequestBody InstructorRequest request) {

        return instructorService.updateInstructorById(instructorId, request);
    }

    @DeleteMapping("/{instructor_id}")
    public ResponseEntity<Response<Instructor>> deleteInstructorById(@PathVariable Long instructor_id) {
        return instructorService.deleteInstructorById(instructor_id);
    }

}
