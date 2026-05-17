package com.courseRegistration.studentRegistration.service;

import com.courseRegistration.studentRegistration.dto.AdminDashboardDTO;
import com.courseRegistration.studentRegistration.dto.StudentSummaryDTO;
import com.courseRegistration.studentRegistration.dto.TransactionSummaryDTO;
import com.courseRegistration.studentRegistration.model.Enrollment;
import com.courseRegistration.studentRegistration.model.Payment;
import com.courseRegistration.studentRegistration.model.Student;
import com.courseRegistration.studentRegistration.repository.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminDashboardService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final PaymentRepository paymentRepository;

    public AdminDashboardService(StudentRepository studentRepository,
                                 CourseRepository courseRepository,
                                 EnrollmentRepository enrollmentRepository,
                                 PaymentRepository paymentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.paymentRepository = paymentRepository;
    }

