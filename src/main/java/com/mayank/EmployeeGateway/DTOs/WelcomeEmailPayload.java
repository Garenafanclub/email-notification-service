package com.mayank.EmployeeGateway.DTOs;

public record WelcomeEmailPayload(
        String event,
        String message,
        String email,
        String departmentId
) {}
