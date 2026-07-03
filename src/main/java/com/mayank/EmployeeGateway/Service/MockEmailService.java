package com.mayank.EmployeeGateway.Service;

import org.springframework.stereotype.Service;

@Service
public class MockEmailService {

    public void dispatchWelcomeEmail(String email, String message)
    {
        System.out.println("\n==================================================");
        System.out.println(" 📧 INTERCEPTED OUTGOING SYSTEM EMAIL 📧 ");
        System.out.println("==================================================");
        System.out.println("TO: " + email);
        System.out.println("SUBJECT: Welcome to ZKTeco! Important Onboarding Info");
        System.out.println("BODY: ");
        System.out.println(message);
        System.out.println("Please use your temporary credentials to log in.");
        System.out.println("==================================================\n");
    }
}
