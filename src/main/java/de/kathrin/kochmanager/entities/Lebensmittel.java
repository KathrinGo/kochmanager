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
    @Column(name = "MDH")
    private String mdh;
    @JoinColumn(name = "MENGE_LAGERUNG")
    @OneToOne(cascade = {CascadeType.ALL})
    private Menge menge;
    @Column(name = "HALTBAR")
    private boolean haltbar;

     public Lebensmittel(String name, String mdh, Einheit einheit) {
        super();
        this.name = name;
        this.mdh=mdh;
        this.menge=new Menge(einheit,0);
       // this.haltbar=istHaltbar();
    }
/*
    public boolean istHaltbar() {
        Objects.nonNull(mdh);
        if (LocalDate.now().isBefore(mdh)) {
            return true;
        } else {
            return false;
        }
    }
*/
    public void mengeHinzufügen(int menge){
         this.menge.mengeHinzufügen(menge);
    }

    public void mengeWegnehmen(int menge){
         this.menge.mengeWegnehmen(menge);
    }

}

