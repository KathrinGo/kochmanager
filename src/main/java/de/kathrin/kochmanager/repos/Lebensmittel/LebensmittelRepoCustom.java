package de.kathrin.kochmanager.repos.Lebensmittel;

import de.kathrin.kochmanager.entities.Lebensmittel;

//Interface, welches selbst programmierte CRUD Methoden beinhaltet
public interface LebensmittelRepoCustom {
    public Lebensmittel saveUsingMerge(Lebensmittel lebensmittel);
}
