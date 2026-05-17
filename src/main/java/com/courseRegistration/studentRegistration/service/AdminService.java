package com.courseRegistration.studentRegistration.service;

import com.courseRegistration.studentRegistration.dto.AdminLoginRequest;
import com.courseRegistration.studentRegistration.dto.AdminRegistrationRequest;
import com.courseRegistration.studentRegistration.dto.AuthResponse;
import com.courseRegistration.studentRegistration.exception.ApiException;
import com.courseRegistration.studentRegistration.model.Admin;
import com.courseRegistration.studentRegistration.repository.AdminRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public AuthResponse register(AdminRegistrationRequest request) {
        requireText(request.name(), "Admin name is required");
        requireText(request.email(), "Admin email is required");
        requireText(request.password(), "Admin password is required");

        if (request.creatorAdminId() == null || !adminRepository.existsById(request.creatorAdminId())) {
            throw new ApiException(HttpStatus.UNAUTHORIZED, "Only a logged in admin can add another admin");
        }

        if (adminRepository.existsByEmail(request.email())) {
            throw new ApiException(HttpStatus.CONFLICT, "This admin email is already registered");
        }

        Admin admin = adminRepository.save(new Admin(request.name(), request.email(), request.password()));
        return new AuthResponse(admin.getId(), admin.getName(), admin.getEmail(), "ADMIN",
                "Admin registered successfully");
    }

    public AuthResponse login(AdminLoginRequest request) {
        requireText(request.email(), "Admin email is required");
        requireText(request.password(), "Admin password is required");

        Admin admin = adminRepository.findByEmailAndPassword(request.email(), request.password())
                .orElseThrow(() -> new ApiException(HttpStatus.UNAUTHORIZED, "Invalid admin login details"));

        return new AuthResponse(admin.getId(), admin.getName(), admin.getEmail(), "ADMIN",
                "Admin login successful");
    }

    private void requireText(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, message);
        }
    }
}




