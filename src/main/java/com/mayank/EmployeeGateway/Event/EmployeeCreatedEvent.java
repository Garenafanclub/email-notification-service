package com.mayank.EmployeeGateway.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreatedEvent {

    private UUID eventId;
    private String eventType;
    private Instant occurredAt;
    private EmployeeCreatedData data;

}


