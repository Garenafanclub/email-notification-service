package com.mayank.EmployeeGateway.Controller;

import com.mayank.EmployeeGateway.Event.EmployeeCreatedEvent;
import com.mayank.EmployeeGateway.Service.EmailNotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/webhooks")
public class WebhookController {

        private final EmailNotificationService emailNotificationService;

        public WebhookController(EmailNotificationService emailNotificationService) {
            this.emailNotificationService = emailNotificationService;
        }

        @PostMapping("/employee-created")
        public ResponseEntity<Void> handleEmployeeCreated(@RequestBody EmployeeCreatedEvent event) {

            emailNotificationService.handleEmployeeCreated(event);

            return ResponseEntity.ok().build();
        }
    }
