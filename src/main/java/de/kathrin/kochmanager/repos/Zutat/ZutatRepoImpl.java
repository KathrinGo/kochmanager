package de.kathrin.kochmanager.repos.Zutat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
@Transactional
public class ZutatRepoImpl {

    @Autowired
    private EntityManager em;

}
