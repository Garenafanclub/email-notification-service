package com.mayank.EmployeeGateway.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreatedData {

    private Long employeeId;
    private String email;
    private Long departmentId;
    private String temporaryPassword;
}
