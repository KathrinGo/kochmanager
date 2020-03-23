package de.kathrin.kochmanager.repos.Rezept;

import de.kathrin.kochmanager.SpringBaseTest;
import de.kathrin.kochmanager.entities.Lebensmittel;
import de.kathrin.kochmanager.entities.Rezept;
import de.kathrin.kochmanager.entities.Zutat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.Commit;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RezeptRepoImplTest extends SpringBaseTest {
    @Autowired
    RezeptRepo rezeptRepo;

    @Value("#{rezeptSpiegelei}")
    Rezept rezeptSpiegelei;
    @Value("#{rezeptRuehrei}")
    Rezept rezeptRuehrei;
    @Value("#{rezeptApfelmus}")
    Rezept rezeptApfelmus;
    @Value("#{zutatEi}")
    Zutat zutatEi;
    @Value("#{zutatButter}")
    Zutat zutatButter;
    @Value("#{zutatMilch}")
    Zutat zutatMilch;


    @Test
    void saveUsingMergeTest() {
        /*assertNull(rezeptApfelmus.getId());
        Rezept savedRezept = rezeptRepo.save(rezeptApfelmus);
        assertTrue(rezeptRepo.findById(savedRezept.getId()).isPresent());
        String beschreibung = "1.Wasche die Äpfel, püriere sie und am ende genieße das Apfelmus!";
        rezeptApfelmus.setBeschreibung(beschreibung);
        Rezept updateRezept = rezeptRepo.saveUsingMerge(rezeptApfelmus);
        assertEquals(beschreibung,rezeptRepo.findById(savedRezept.getId()).get().getBeschreibung());*/
    }
    @Test
    @Commit
    void saveTest() {
        assertNull(rezeptRuehrei.getId());
        rezeptRuehrei.addZutaten(zutatMilch);
        rezeptRuehrei.addZutaten(zutatButter);
        rezeptRuehrei.addZutaten(zutatEi);
        Rezept savedRezept = rezeptRepo.save(rezeptRuehrei);
        assertTrue(rezeptRepo.findById(savedRezept.getId()).isPresent());
    }
}