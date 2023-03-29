package com.sergioruy.booking;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class ReadnessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        if (Booking.listAll() == null) {
            return HealthCheckResponse.down("I'm not ready");
        } else {
            return HealthCheckResponse.up("I'm ready");
        }
    }
}
