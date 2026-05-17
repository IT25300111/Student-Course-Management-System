package com.courseRegistration.studentRegistration.controller;

import com.courseRegistration.studentRegistration.dto.ApiMessage;
import com.courseRegistration.studentRegistration.model.Enrollment;
import com.courseRegistration.studentRegistration.service.EnrollmentService;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/student/{studentId}")
    public List<Enrollment> getEnrollmentsByStudent(@PathVariable Long studentId) {
        return enrollmentService.getEnrollmentsByStudent(studentId);
    }
    // Add this method - for DELETE (Cancel Enrollment)
    @DeleteMapping("/{id}")
    public ApiMessage cancelEnrollment(@PathVariable Long id) {
        enrollmentService.cancelEnrollment(id);
        return new ApiMessage("Enrollment cancelled successfully");
    }

}