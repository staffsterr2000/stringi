package com.staffsterr2000.stringi.config;

import com.staffsterr2000.stringi.service.StringService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class StringInitializer {

    private final StringService stringService;

    @Bean
    public CommandLineRunner initializeStrings() {
        return args -> stringService.generateStrings();
    }

}
