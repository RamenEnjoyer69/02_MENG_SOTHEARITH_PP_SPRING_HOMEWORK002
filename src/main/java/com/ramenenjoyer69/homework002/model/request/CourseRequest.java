package com.ramenenjoyer69.homework002.model.request;

import com.ramenenjoyer69.homework002.model.entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String courseName;
    private String description;
    private Long instructorId;
}
