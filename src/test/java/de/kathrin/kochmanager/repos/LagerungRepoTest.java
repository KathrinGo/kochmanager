package de.kathrin.kochmanager.repos;

import de.kathrin.kochmanager.Exception.AnzahlKleinerNull;
import de.kathrin.kochmanager.SpringBaseTest;
import de.kathrin.kochmanager.entities.Lagerung;
import de.kathrin.kochmanager.entities.Lebensmittel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.*;

class LagerungRepoTest extends SpringBaseTest {
    @Autowired
    LagerungRepo lagerungRepo;

    @Value("#{lagerung}")
    Lagerung lagerung;

    @Value("#{lebensmittelButter}")
    Lebensmittel lebensmittelButter;

    @Value("#{lebensmittelApfel}")
    Lebensmittel lebensmittelApfel;

    @Test
    @Commit
    public void testSave()throws AnzahlKleinerNull {
        assertNull(lagerung.getId());
        lagerung.lebensmittelHinzufuegen(lebensmittelApfel,6);
        lagerung.lebensmittelHinzufuegen(lebensmittelButter,52);
        Lagerung savedLgaerung = lagerungRepo.save(lagerung);
        assertNotNull(lagerung.getId());
    }
}