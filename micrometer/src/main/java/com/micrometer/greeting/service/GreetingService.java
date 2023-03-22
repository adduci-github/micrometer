package com.micrometer.greeting.service;

import com.micrometer.greeting.record.Greeting;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.observability.micrometer.Micrometer;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Random;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class GreetingService {
    private final ObservationRegistry registry;
    private final CreateService createService;

    public Mono<Greeting> greeting(String name) {
        return createService
                .create(name)
                .name("greeting.call")
                .tap(Micrometer.observation(registry));
    }
}
