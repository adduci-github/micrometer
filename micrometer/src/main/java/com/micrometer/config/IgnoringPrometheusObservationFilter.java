package com.micrometer.config;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationFilter;

public class IgnoringPrometheusObservationFilter implements ObservationFilter {
    @Override
    public Observation.Context map(Observation.Context context) {
        if (context.getName().startsWith("http.server.requests") && context.getContextualName().startsWith("http get /actuator/prometheus")) {
            return null;
        }
        return context;
    }
}
