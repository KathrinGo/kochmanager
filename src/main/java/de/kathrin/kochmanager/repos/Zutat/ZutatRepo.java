package de.kathrin.kochmanager.repos.Zutat;

import de.kathrin.kochmanager.entities.Zutat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZutatRepo extends JpaRepository<Zutat,Long>, RezeptRepoCustom {
}
