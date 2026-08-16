package com.mayank.EmployeeGateway.Event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationCompletedEvent {

    private UUID eventId;

    private UUID operationId;

    private String eventType;

    private Instant occurredAt;

    private NotificationCompletionData data;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NotificationCompletionData {

        private Long employeeId;

        private String status;
    }
}
