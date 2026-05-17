package com.courseRegistration.studentRegistration.dto;

import java.math.BigDecimal;

public record RegistrationResponse(
        Long enrollmentId,
        Long studentId,
        String studentName,
        String courseTitle,
        BigDecimal amount,
        String paymentStatus,
        String transactionReference,
        String message

) {
}
