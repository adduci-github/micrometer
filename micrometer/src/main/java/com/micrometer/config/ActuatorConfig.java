package com.micrometer.config;

import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ActuatorConfig {
    @Bean
    public MeterRegistryCustomizer meterRegistryCustomizer() {
        return registry -> registry.config().meterFilter(new IgnoringActuatorMeterFilter());
    }
}
