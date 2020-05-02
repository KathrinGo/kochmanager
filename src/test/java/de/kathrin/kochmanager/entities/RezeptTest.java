package de.kathrin.kochmanager.entities;

import de.kathrin.kochmanager.Exception.AnzahlKleinerNull;
import de.kathrin.kochmanager.SpringBaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.*;

class RezeptTest extends SpringBaseTest {
    @Value("#{rezeptSpiegelei}")
    private Rezept rezeptSpiegelEi;
   // @Value("#{lagerung}")
    //private Lagerung lagerung;
    @Value("#{lebensmittelEi}")
    private Lebensmittel lebensmittelEi;
    @Value("#{lebensmittelButter}")
    private Lebensmittel lebensmittelButter;
/*
    @Test
    void lebensmittelVorraetig() throws AnzahlKleinerNull {
        lagerung.lebensmittelHinzufuegen(lebensmittelButter,200);
        lagerung.lebensmittelHinzufuegen(lebensmittelEi,5);
        boolean vollständig = rezeptSpiegelEi.lebensmittelVorraetig(lagerung);
        assertTrue(rezeptSpiegelEi.isZutatVollstaendig());
    }

    @Test
    void lebensmittelNichtVorraetig() throws AnzahlKleinerNull {
        lagerung.lebensmittelHinzufuegen(lebensmittelButter,40);
        lagerung.lebensmittelHinzufuegen(lebensmittelEi,1);
        assertFalse(rezeptSpiegelEi.isZutatVollstaendig());
    }*/
}
