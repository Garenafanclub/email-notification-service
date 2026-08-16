package com.mayank.EmployeeGateway.Event;

public interface NotificationEventPublisher {
    void publishNotificationCompleted(NotificationCompletedEvent event);
}
