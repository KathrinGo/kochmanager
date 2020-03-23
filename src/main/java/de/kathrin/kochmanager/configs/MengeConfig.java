package de.kathrin.kochmanager.configs;

import de.kathrin.kochmanager.entities.Menge;
import de.kathrin.kochmanager.enums.Einheit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@Slf4j
public class MengeConfig {
    @Bean
    public Menge mengeHundertGramm(){
        Menge menge = new Menge();
        menge.setEinheit(Einheit.GRAMM);
        menge.setMenge(100);
        return menge;
    }

    @Bean
    public Menge mengeHundertLiter(){
        Menge menge = new Menge();
        menge.setEinheit(Einheit.LITER);
        menge.setMenge(100);
        return menge;
    }

    @Bean
    public Menge mengeDreiStueck(){
        Menge menge = new Menge();
        menge.setEinheit(Einheit.STÜCK);
        menge.setMenge(3);
        return menge;
    }

}
