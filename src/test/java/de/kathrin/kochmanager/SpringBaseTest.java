package de.kathrin.kochmanager;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@Slf4j
public class SpringBaseTest {
    @Autowired
    @Getter
    private EntityManager em;

    //Hier wird ein EntityManager angelegt. Sobald einer offen ist, wird kein weiterer geöffnet.
    //Das JpaRepostory sieht, dass bereits einer offen ist und öffnet daraufhin keinen Neuen.
    //Mit FLush werden die Daten synchronisiert um sie in die Datenbank zu schreiben.
    //Unterschied: Mit Flush in die DB schreiben oder mit commit "richtig" in die DB schreiben, damit es wirklich bleibt

    @AfterEach
    void afterEach(){
        log.info("flushing EntityManager");
        em.flush();
    }
}
