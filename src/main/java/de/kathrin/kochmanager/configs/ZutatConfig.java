package de.kathrin.kochmanager.configs;

import de.kathrin.kochmanager.entities.Lebensmittel;
import de.kathrin.kochmanager.entities.Menge;
import de.kathrin.kochmanager.entities.Zutat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ZutatConfig {
   /* @Value("#{lebensmittelButter}")
    private Lebensmittel lebensmittelButter;
    @Value("#{lebensmittelEi}")
    private Lebensmittel lebensmittelEi;
    @Value("#{lebensmittelMilch}")
    private Lebensmittel lebensmittelMilch;
    @Value("#{mengeDreiStueck}")
    private Menge dreiStueck;
    @Value("#{mengeHundertGramm}")
    private Menge hundertGramm;
    @Value("#{mengeHundertLiter}")
    private Menge hundertLiter;

    @Bean
    public Zutat zutatEi(){
        Zutat zutat = new Zutat();
        zutat.setLebensmittel(lebensmittelEi);
        zutat.setMenge(dreiStueck);
        return zutat;
    }

    @Bean
    public Zutat zutatButter(){
        Zutat zutat = new Zutat();
        zutat.setLebensmittel(lebensmittelButter);
        zutat.setMenge(hundertGramm);
        return zutat;
    }

    @Bean
    public Zutat zutatMilch(){
        Zutat zutat = new Zutat();
        zutat.setLebensmittel(lebensmittelMilch);
        zutat.setMenge(hundertLiter);
        return zutat;
    }
    @Bean
    public Zutat zutatApfel(){
        Zutat zutat = new Zutat();
        zutat.setLebensmittel(lebensmittelMilch);
        zutat.setMenge(hundertLiter);
        return zutat;
    }*/
}
