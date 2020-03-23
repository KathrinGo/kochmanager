package de.kathrin.kochmanager.repos.Rezept;

import de.kathrin.kochmanager.entities.Rezept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class RezeptRepoImpl implements RezeptRepoCustom{
    @Autowired
    private EntityManager em;

    public Rezept saveUsingMerge(Rezept rezept) {
        return em.merge(rezept);
    }
}
