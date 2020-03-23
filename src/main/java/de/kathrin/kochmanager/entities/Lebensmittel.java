package de.kathrin.kochmanager.entities;

import de.kathrin.kochmanager.enums.Einheit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "LEBENSMITTEL")
public class Lebensmittel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @NonNull
    @Column(name = "NAME")
    private String name;
    @NonNull
    @Column(name = "MDH")
    private LocalDate mdh;
    @ManyToOne//(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "ID_LAGERUNG")
    private Lagerung lagerung;
    @JoinColumn(name = "MENGE_LAGERUNG")
    @OneToOne(cascade = {CascadeType.ALL})
    private Menge menge;
    @Column(name = "HALTBAR")
    private boolean haltbar;

     public Lebensmittel(String name, LocalDate mdh, Einheit einheit) {
        super();
        this.name = name;
        this.mdh=mdh;
        this.menge=new Menge(einheit,0);
        this.haltbar=istHaltbar();
    }

    public boolean istHaltbar() {
        Objects.nonNull(mdh);
        if (LocalDate.now().isBefore(mdh)) {
            return true;
        } else {
            return false;
        }
    }

    public void mengeHinzufügen(int menge){
         this.menge.mengeHinzufügen(menge);
    }

    public void mengeWegnehmen(int menge){
         this.menge.mengeWegnehmen(menge);
    }

}

