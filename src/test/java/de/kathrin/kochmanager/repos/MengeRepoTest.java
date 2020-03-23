package de.kathrin.kochmanager.repos;

import de.kathrin.kochmanager.SpringBaseTest;
import de.kathrin.kochmanager.entities.Menge;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.*;

class MengeRepoTest extends SpringBaseTest {
    @Autowired
    MengeRepo mengeRepo;

    @Value("#{mengeHundertGramm}")
    Menge hundertGramm;

    @Test
    @Commit
    void testSave(){
        Menge savedMenge = mengeRepo.save(hundertGramm);
        assertNotNull(savedMenge.getId());
    }
}