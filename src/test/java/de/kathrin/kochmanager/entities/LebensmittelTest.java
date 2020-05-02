package de.kathrin.kochmanager.entities;

import de.kathrin.kochmanager.SpringBaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class LebensmittelTest extends SpringBaseTest {
    @Value("#{lebensmittelBrot}")
    private Lebensmittel lebensmittelBrot;

    @Value("#{lebensmittelJogurt}")
    private Lebensmittel lebensmittelJogurt;
    @Test
    void testObjektAnlegen(){
       // assertTrue(lebensmittelBrot.istHaltbar());
       // assertFalse(lebensmittelJogurt.istHaltbar());
    }
}
