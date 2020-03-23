package de.kathrin.kochmanager.entities;

import de.kathrin.kochmanager.Exception.AnzahlKleinerNull;
import de.kathrin.kochmanager.SpringBaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LagerungTest extends SpringBaseTest {
    @Autowired
    Lagerung lagerung;

    @Value("#{lebensmittelApfel}")
    Lebensmittel lebensmittelApfel;

    @Value("#{lebensmittelButter}")
    Lebensmittel lebensmittelButter;

    @Value("#{lebensmittelMehl}")
    Lebensmittel lebensmittelMehl;

    @Value("#{lebensmittelMilch}")
    Lebensmittel lebensmittelMilch;

    @Test
    void lebensmittelHinzufuegen() throws AnzahlKleinerNull{
        assertFalse(lagerung.getVorrat().contains(lebensmittelApfel));
        assertThrows(AnzahlKleinerNull.class,()->lagerung.lebensmittelHinzufuegen(lebensmittelApfel,0));
        lagerung.lebensmittelHinzufuegen(lebensmittelApfel,3);
        assertTrue(lagerung.getVorrat().contains(lebensmittelApfel));
        for (Lebensmittel l :lagerung.getVorrat()) {
            if(l==lebensmittelApfel){
                assertEquals(3,l.getMenge().getMenge());
            }
        }
    }
    @Test
    void lebensmittelErweitern() throws AnzahlKleinerNull {
        assertFalse(lagerung.getVorrat().contains(lebensmittelMehl));
        lagerung.lebensmittelHinzufuegen(lebensmittelMehl,100);
        assertTrue(lagerung.getVorrat().contains(lebensmittelMehl));
        lagerung.lebensmittelHinzufuegen(lebensmittelMehl,100);
        for (Lebensmittel l :lagerung.getVorrat()) {
            if(l==lebensmittelMehl){
                assertEquals(200,l.getMenge().getMenge());
            }
        }
    }
    @Test
    void lebensmittelVerringern() throws AnzahlKleinerNull{
        assertFalse(lagerung.getVorrat().contains(lebensmittelButter));
        lagerung.lebensmittelHinzufuegen(lebensmittelButter,200);
        assertTrue(lagerung.getVorrat().contains(lebensmittelButter));
        lagerung.lebensmittelRausnehmen(lebensmittelButter,100);
        for (Lebensmittel l :lagerung.getVorrat()) {
            if(l==lebensmittelButter){
                assertEquals(100,l.getMenge().getMenge());
            }
        }
    }
    @Test
    void lebensmittelRausnehmen() throws AnzahlKleinerNull{
        assertFalse(lagerung.getVorrat().contains(lebensmittelMilch));
        lagerung.lebensmittelHinzufuegen(lebensmittelMilch,200);
        assertTrue(lagerung.getVorrat().contains(lebensmittelMilch));
        lagerung.lebensmittelRausnehmen(lebensmittelMilch,200);
        assertFalse(lagerung.getVorrat().contains(lebensmittelMilch));
    }
}