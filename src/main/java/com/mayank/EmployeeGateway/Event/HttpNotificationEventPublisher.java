package com.mayank.EmployeeGateway.Event;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class HttpNotificationEventPublisher implements NotificationEventPublisher {

    private final RestClient restClient;

    @Value("${webhook.secret}")
    private String webhookSecret;

    @Value(("${employee.notification.completion-webhook.url}"))
    private String completionWebhookURL;

    public HttpNotificationEventPublisher(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public void publishNotificationCompleted(NotificationCompletedEvent event) {
        try{
            System.out.println("Calling Employee Service completion webhook for operation: "
                                   + event.getOperationId());


            ResponseEntity<Void> response = restClient.post()
                    .uri(completionWebhookURL)
                    .header("Content-Type", "application/json")
                    .header("X-Webhook-Secret", webhookSecret)
                    .body(event)
                    .retrieve()
                    .toBodilessEntity();

            System.out.println("Employee Service responded with: " + response.getStatusCode());
        } catch (Exception e)
        {
            System.out.println("Failed to call Employee Service completion webhook for operation: "
                               + event.getOperationId() + ". Error: " + e.getMessage());
        }
    }
}
