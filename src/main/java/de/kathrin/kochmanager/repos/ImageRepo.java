package de.kathrin.kochmanager.repos;

import de.kathrin.kochmanager.entities.ImageRezept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepo extends JpaRepository<ImageRezept, Long> {

    Optional<ImageRezept> findByName(String name);

}
