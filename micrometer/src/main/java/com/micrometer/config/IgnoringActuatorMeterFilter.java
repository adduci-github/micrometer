package com.micrometer.config;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micrometer.core.instrument.config.MeterFilterReply;

public class IgnoringActuatorMeterFilter implements MeterFilter {

    @Override
    public MeterFilterReply accept(Meter.Id id) {
        if (id.getName().startsWith("http.server.requests") && (id.getTag("uri").startsWith("/actuator") || id.getTag("uri").contains("instances"))) {
            return MeterFilterReply.DENY;
        }
        return MeterFilterReply.NEUTRAL;
    }
}
