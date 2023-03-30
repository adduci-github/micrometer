package com.micrometer.config;

import brave.handler.MutableSpan;
import brave.handler.SpanHandler;
import brave.propagation.TraceContext;
import org.springframework.stereotype.Component;

@Component
public class CustomSpanHandler extends SpanHandler {

    @Override
    public boolean end(TraceContext context, MutableSpan span, Cause cause) {
        if (span.tag("uri") != null && (span.tag("uri").contains("actuator") || span.tag("uri").contains("instances"))) {
            return false;
        }

        return super.end(context, span, cause);
    }
}
