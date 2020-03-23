package de.kathrin.kochmanager.repos.Lebensmittel;

import de.kathrin.kochmanager.entities.Lebensmittel;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface, welches das JPA Repository mit den CRUD Operatoren erbt
public interface LebensmittelRepo extends JpaRepository<Lebensmittel,Long>, LebensmittelRepoCustom {
}
