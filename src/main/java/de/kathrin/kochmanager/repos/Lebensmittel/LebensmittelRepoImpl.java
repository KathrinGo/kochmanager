package de.kathrin.kochmanager.repos.Lebensmittel;

import de.kathrin.kochmanager.entities.Lebensmittel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
//Klasse implementiert das CustomRepo und füllt die MEthoden des Interfaces
public class LebensmittelRepoImpl implements LebensmittelRepoCustom{
    @Autowired
    private EntityManager em;

    public Lebensmittel saveUsingMerge(Lebensmittel lebensmittel){
        return em.merge(lebensmittel);
    }
}
