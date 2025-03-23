package com.ramenenjoyer69.homework002.controller;


import com.ramenenjoyer69.homework002.model.entity.Instructor;
import com.ramenenjoyer69.homework002.model.request.InstructorRequest;
import com.ramenenjoyer69.homework002.model.response.Response;
import com.ramenenjoyer69.homework002.service.InstructorService;
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
    public Instructor saveInstructor(@RequestBody InstructorRequest request) {

        return instructorService.saveInstructor(request);
    }

    @GetMapping("/{instructor_id}")
    public Instructor getInstructorById(@PathVariable Long instructor_id) {

        return instructorService.getInstructorById(instructor_id);
    }

    @PutMapping("/{instructor-id}")
    public Instructor updateInstructor(@PathVariable("instructor-id") Long instructorId, @RequestBody InstructorRequest request) {

        return instructorService.updateInstructorById(instructorId, request);
    }

    @DeleteMapping("/{instructor_id}")
    public Instructor deleteInstructorById(@PathVariable Long instructor_id) {
        return instructorService.deleteInstructorById(instructor_id);
    }

}
