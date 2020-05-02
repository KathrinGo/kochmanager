package de.kathrin.kochmanager.entities;

import de.kathrin.kochmanager.enums.Einheit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "MENGE")
public class Menge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "MENGE")
    private int menge;
    @Column(name = "EINHEIT")
    @Enumerated(EnumType.STRING)
    private Einheit einheit;
    public Menge(Einheit einheit, int menge){
        Objects.nonNull(einheit);
        Objects.nonNull(menge);

        this.menge = menge;
        this.einheit = einheit;

    }

    public void mengeHinzufügen(int m){
        this.menge+=m;
    }

    public void mengeWegnehmen(int m){
        this.menge-=m;
    }
}
