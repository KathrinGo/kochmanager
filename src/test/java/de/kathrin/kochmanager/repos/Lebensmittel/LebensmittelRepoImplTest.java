package de.kathrin.kochmanager.repos.Lebensmittel;

import de.kathrin.kochmanager.SpringBaseTest;
import de.kathrin.kochmanager.entities.Lebensmittel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LebensmittelRepoImplTest extends SpringBaseTest {
    @Autowired
   private LebensmittelRepo lebensmittelRepo;

    @Value("#{lebensmittelApfel}")
    private Lebensmittel lebensmittelApfel;

    @Value("#{lebensmittelBrot}")
    private Lebensmittel lebensmittelBrot;

    @Value("#{lebensmittelMilch}")
    private Lebensmittel lebensmittelMilch;

    @Value("#{lebensmittelJogurt}")
    private Lebensmittel lebensmittelJogurt;

    @Test
    void saveUsingMerge() {
      /*  assertNull(lebensmittelBrot.getId());
        Lebensmittel savedLebensmittel = lebensmittelRepo.save(lebensmittelBrot);
        assertTrue(lebensmittelRepo.findById(savedLebensmittel.getId()).isPresent());
        lebensmittelBrot.setMdh(LocalDate.now().plusDays(3));
        Lebensmittel updateLebensmittel = lebensmittelRepo.saveUsingMerge(lebensmittelBrot);
        assertEquals(LocalDate.now().plusDays(3),updateLebensmittel.getMdh());*/
    }

    @Test
    @Commit
    void testSave(){
        assertNull(lebensmittelJogurt.getId());
        Lebensmittel savedLebensmittel = lebensmittelRepo.save(lebensmittelJogurt);
        assertTrue(lebensmittelRepo.findById(savedLebensmittel.getId()).isPresent());
    }

}
