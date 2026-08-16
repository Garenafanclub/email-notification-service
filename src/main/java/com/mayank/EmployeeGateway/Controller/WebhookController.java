package com.mayank.EmployeeGateway.Controller;

import com.mayank.EmployeeGateway.Event.NotificationRequestEvent;
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

        @PostMapping("/notification-requested")
        public ResponseEntity<Void> handleNotificationRequest(@RequestBody NotificationRequestEvent event) {

            System.out.println("Notification request received");
            System.out.println("Event ID: " + event.getEventId());
            System.out.println("Operation ID: " + event.getOperationId());
            System.out.println("Event Type: " + event.getEventType());


            System.out.println("Processing notification asynchronously...");
            System.out.println(
                    "HTTP THREAD: " + Thread.currentThread().getName()
            );
            emailNotificationService.handleEmployeeCreated(event);

            return ResponseEntity.accepted().build();
        }
    }
