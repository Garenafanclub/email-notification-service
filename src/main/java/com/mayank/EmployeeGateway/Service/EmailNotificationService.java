package com.mayank.EmployeeGateway.Service;

import com.mayank.EmployeeGateway.Event.HttpNotificationEventPublisher;
import com.mayank.EmployeeGateway.Event.NotificationCompletedEvent;
import com.mayank.EmployeeGateway.Event.NotificationRequestEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class EmailNotificationService {

    private final MockEmailService mockEmailService;
    private final HttpNotificationEventPublisher notificationEventPublisher;

    public EmailNotificationService(MockEmailService mockEmailService, HttpNotificationEventPublisher notificationEventPublisher) {
        this.mockEmailService = mockEmailService;
        this.notificationEventPublisher = notificationEventPublisher;
    }

    @Async
    public void handleEmployeeCreated(NotificationRequestEvent event) {

        System.out.println(
                "ASYNC PROCESSING STARTED - Operation ID: "
                + event.getOperationId()
        );

        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String email = event.getData().getEmail();

        String message = """
                Welcome to ZKTeco!

                Your employee account has been successfully created.

                Employee ID: %s
                Department ID: %s

                Temporary Password: %s

                """.formatted(
                event.getData().getEmpId(),
                event.getData().getDepId(),
                event.getData().getTempPass()
        );

        mockEmailService.dispatchWelcomeEmail(email, message);

        NotificationCompletedEvent completedEvent =
                new NotificationCompletedEvent(
                        UUID.randomUUID(),
                        event.getOperationId(),
                        "notification.completed",
                        Instant.now(),
                        new NotificationCompletedEvent.NotificationCompletionData(
                                event.getData().getEmpId(),
                                "SUCCESS"
                        )
                );
        notificationEventPublisher.publishNotificationCompleted(completedEvent);

        System.out.println(
                "ASYNC PROCESSING COMPLETED - Operation ID: "
                        + event.getOperationId()
        );
    }
}
