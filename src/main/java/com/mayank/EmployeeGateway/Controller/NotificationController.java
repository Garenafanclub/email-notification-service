package com.mayank.EmployeeGateway.Controller;

import com.mayank.EmployeeGateway.DTOs.WelcomeEmailPayload;
import com.mayank.EmployeeGateway.Service.MockEmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final MockEmailService mockEmailService;

    public NotificationController(MockEmailService mockEmailService) {
        this.mockEmailService = mockEmailService;
    }

    @PostMapping("/welcome")
    public ResponseEntity<String> receiveWelcomeHook(@RequestBody WelcomeEmailPayload EmailPayload)
    {
        System.out.println("Received webhook event: " + EmailPayload.event() + " for " + EmailPayload.email());

        mockEmailService.dispatchWelcomeEmail(EmailPayload.email(), EmailPayload.message());

        return ResponseEntity.ok("Email processed successfully");
    }
}
