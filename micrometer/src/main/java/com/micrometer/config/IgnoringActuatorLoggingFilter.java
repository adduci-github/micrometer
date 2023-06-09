package com.micrometer.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class IgnoringActuatorLoggingFilter extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent loggingEvent) {
        if (isPrometheus(loggingEvent.getMessage())) {
            return FilterReply.DENY;
        } else {
            return FilterReply.ACCEPT;
        }
    }

    private boolean isPrometheus(String message) {
        return message.contains("actuator")
                || message.contains("instances");
    }
}
