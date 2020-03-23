package de.kathrin.kochmanager.configs;

import de.kathrin.kochmanager.entities.Lebensmittel;
import de.kathrin.kochmanager.entities.Menge;
import de.kathrin.kochmanager.enums.Einheit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.*;
//Konfiguriert die Beans, die verwendet werden um kontrolliert Objekte zu verwenden/erzeugen

@Configuration
@Slf4j
public class LebensmittelConfig {

    @Bean
    public Lebensmittel lebensmittelApfel() {
        log.info("Lebensmittel Apfel was called");
        return new Lebensmittel("Apfel", LocalDate.now().plusDays(3), Einheit.STÜCK);
    }

    @Bean
    public Lebensmittel lebensmittelBrot() {
        log.info("Lebensmittel Brot was called");
        return new Lebensmittel("Brot", LocalDate.now().plusDays(6),Einheit.GRAMM);
    }

    @Bean
    public Lebensmittel lebensmittelJogurt() {
        log.info("Lebensmittel Jogurt was called");
        return new Lebensmittel("Jogurt", LocalDate.now().minusDays(2),Einheit.GRAMM);
    }

    @Bean
    public Lebensmittel lebensmittelEi() {
        log.info("Lebensmittel Ei was called");
        return new Lebensmittel("Ei", LocalDate.now().plusDays(8),Einheit.STÜCK);
    }

    @Bean
    public Lebensmittel lebensmittelButter() {
        log.info("Lebensmittel Butter was called");
        return new Lebensmittel("Butter", LocalDate.now().plusDays(10),Einheit.GRAMM);
    }
    @Bean
    public Lebensmittel lebensmittelMehl() {
        log.info("Lebensmittel Mehl was called");
        return new Lebensmittel("Mehl", LocalDate.now().plusDays(10),Einheit.GRAMM);
    }

    @Bean
    public Lebensmittel lebensmittelMilch() {
        log.info("Lebensmittel Mehl was called");
        return new Lebensmittel("Milch", LocalDate.now().plusDays(10),Einheit.LITER);
    }

    @Bean
    public Map<Lebensmittel,Integer> lebensmittelSpiegelei() {
        Map<Lebensmittel,Integer>zutatenSpiegelei = new HashMap<>();
        zutatenSpiegelei.put(lebensmittelEi(),4);
        zutatenSpiegelei.put(lebensmittelButter(),10);
        return zutatenSpiegelei;

    }
}
