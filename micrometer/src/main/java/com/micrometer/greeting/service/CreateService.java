package com.micrometer.greeting.service;

import com.micrometer.greeting.record.Greeting;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.observability.micrometer.Micrometer;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateService {
    private final ObservationRegistry registry;

    public Mono<Greeting> create(String name) {
        return Mono
                .just(new Greeting(name))
                .name("greeting.create")
                .tap(Micrometer.observation(registry));
    }
}
