package de.kathrin.kochmanager.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LagerungConfig {
    @Bean
    public Lagerung lagerung(){
        return new Lagerung();
    }
}
