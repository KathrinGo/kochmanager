package de.kathrin.kochmanager.repos.Rezept;

import de.kathrin.kochmanager.entities.Rezept;

public interface RezeptRepoCustom {
    public Rezept saveUsingMerge(Rezept rezept);
}
