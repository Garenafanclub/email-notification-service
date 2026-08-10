package com.mayank.EmployeeGateway.Service;

import com.mayank.EmployeeGateway.Event.EmployeeCreatedEvent;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    private final MockEmailService mockEmailService;

    public EmailNotificationService(MockEmailService mockEmailService) {
        this.mockEmailService = mockEmailService;
    }

    public void handleEmployeeCreated(EmployeeCreatedEvent event) {

        String email = event.getData().getEmail();

        String message = """
                Welcome to ZKTeco!
                
                Your employee account has been successfully created.
                
                Employee ID: %s
                Department ID: %s
                
                Temporary Password: %s
                
                Please use these temporary credentials to log in.
                """.formatted(
                event.getData().getEmployeeId(),
                event.getData().getDepartmentId(),
                event.getData().getTemporaryPassword()
        );

        mockEmailService.dispatchWelcomeEmail(email, message);
    }
}
