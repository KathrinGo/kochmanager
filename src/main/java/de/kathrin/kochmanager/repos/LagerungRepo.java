package de.kathrin.kochmanager.repos;

import de.kathrin.kochmanager.entities.Lagerung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LagerungRepo extends JpaRepository<Lagerung,Long> {
}
