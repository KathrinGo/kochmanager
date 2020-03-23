package de.kathrin.kochmanager.entities;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REZEPTE")
public class Rezept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @OneToMany(mappedBy = "rezept", cascade = CascadeType.ALL)
    private List<Zutat>zutaten=new ArrayList<>();
    @Column(name = "TITEL")
    private String title;
    @Column(name = "BESCHREIBUNG")
    private String beschreibung;
    @Column(name = "ZUTATEN_VOLLSTÄNDIG")
    boolean zutatVollstaendig;

    public boolean lebensmittelVorraetig(Lagerung lagerung) {
        Objects.nonNull(lagerung);
        zutatVollstaendig = false;

        zutaten.forEach((zutat)->{
            if(lagerung.getVorrat().contains(zutat.getLebensmittel())){
                for (Lebensmittel l:lagerung.getVorrat()) {
                    if(l.equals(zutat.getLebensmittel())) {
                        if(l.getMenge().getMenge()>=zutat.getMenge().getMenge()&&l.getMenge().getEinheit().equals(zutat.getMenge().getEinheit())) {
                            zutatVollstaendig=true;
                        }
                    }
                }
            }
        });

        return zutatVollstaendig;
    }
    public void addZutaten(Zutat zutat){
        zutaten.add(zutat);
    }
}
