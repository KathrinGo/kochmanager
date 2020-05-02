package de.kathrin.kochmanager.entities;

import de.kathrin.kochmanager.SpringBaseTest;
import de.kathrin.kochmanager.enums.Einheit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
class MengeTest extends SpringBaseTest {


    @Value("#{mengeHundertGramm}")
    Menge mengeGramm;

    @Value("#{mengeHundertLiter}")
    Menge mengeLiter;

    @Test
    void mengeHinzufügen() {
        mengeGramm.mengeHinzufügen(40);
        assertEquals(140,mengeGramm.getMenge());
    }

    @Test
    void mengeWegnehmen() {
        mengeLiter.mengeWegnehmen(40);
        assertEquals(60,mengeLiter.getMenge());
    }

}
