package de.kathrin.kochmanager.repos.Zutat;

import de.kathrin.kochmanager.SpringBaseTest;
import de.kathrin.kochmanager.entities.Zutat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.*;

class ZutatRepoImplTest extends SpringBaseTest {
    @Autowired
    ZutatRepo zutatRepo;

    @Value("#{zutatEi}")
    Zutat zutatEi;

    @Test
    @Commit
    void testSave(){

        Zutat gespeicherteZutat = zutatRepo.save(zutatEi);
        assertNotNull(gespeicherteZutat.getId());
    }
}