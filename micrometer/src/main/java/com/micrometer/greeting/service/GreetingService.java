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

    public Mono<Greeting> greeting(String name) {
        return Mono
                .just(new Greeting(name));
    }
}
