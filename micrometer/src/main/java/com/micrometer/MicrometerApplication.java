package com.micrometer;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.ObservationTextPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Hooks;

@SpringBootApplication
public class MicrometerApplication {
    public static void main(String[] args) {
        Hooks.enableAutomaticContextPropagation();
        SpringApplication.run(MicrometerApplication.class, args);
    }

    @Bean
    public ObservationTextPublisher printingObservationHandler() {
        return new ObservationTextPublisher();
    }

    @Bean
    ObservationRegistry observationRegistry() {
        ObservationRegistry registry = ObservationRegistry.create();
        registry.observationConfig().observationHandler(printingObservationHandler());

        return registry;
    }
}
