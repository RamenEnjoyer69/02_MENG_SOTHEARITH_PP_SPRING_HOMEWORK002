package com.ramenenjoyer69.homework002.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourse {
    private Long id;
    private Long studentId;
    private Long courseId;
}
