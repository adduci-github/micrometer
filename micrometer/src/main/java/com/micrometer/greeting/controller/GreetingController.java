package com.micrometer.greeting.controller;

import com.micrometer.config.IgnoringPrometheusMeterFilter;
import com.micrometer.greeting.record.Greeting;
import com.micrometer.greeting.service.GreetingService;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.observability.micrometer.Micrometer;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class GreetingController {
    private final GreetingService service;
    private final ObservationRegistry registry;

    @GetMapping("/hello/{name}")
    public Mono<Greeting> greeting(@PathVariable("name") String name) {
        return service.greeting(name)
                .name("greeting.call")
                .tap(Micrometer.observation(registry));
    }
}
