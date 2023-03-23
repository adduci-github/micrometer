package com.micrometer.greeting.service;

import com.micrometer.greeting.record.Greeting;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.observability.micrometer.Micrometer;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Random;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@Slf4j
public class GreetingService {
    private final ObservationRegistry registry;

    public Mono<Greeting> greeting(String name) {
        log.info("Greeting Log");
        return Mono
                .just(new Greeting(name))
                .name("greeting.create")
                .tap(Micrometer.observation(registry));
    }
}
