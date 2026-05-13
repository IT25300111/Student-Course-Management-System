package com.courseRegistration.studentRegistration.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String paymentMethod;

    private String cardHolderName;

    @Column(nullable = false, unique = true)
    private String transactionReference;

    @Column(nullable = false)
    private String status;

    private LocalDateTime paidAt;

    public Payment() {
    }

    public Payment(BigDecimal amount, String paymentMethod, String cardHolderName, String transactionReference) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.cardHolderName = cardHolderName;
        this.transactionReference = transactionReference;
        this.status = "PAID";
        this.paidAt = LocalDateTime.now();
    }
}

