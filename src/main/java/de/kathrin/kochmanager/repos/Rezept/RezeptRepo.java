package de.kathrin.kochmanager.repos.Rezept;

import de.kathrin.kochmanager.entities.Rezept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezeptRepo extends JpaRepository<Rezept,Long>, RezeptRepoCustom {
}
