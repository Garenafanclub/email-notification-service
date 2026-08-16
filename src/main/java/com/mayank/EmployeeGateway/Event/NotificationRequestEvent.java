package com.mayank.EmployeeGateway.Event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequestEvent {

        private UUID eventId;

        private UUID operationId;

        private String eventType;

        private Instant occurredAt;

        private NotificationData data;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class NotificationData {

            private Long empId;

            private String email;

            private Long depId;

            private String tempPass;
        }
}
