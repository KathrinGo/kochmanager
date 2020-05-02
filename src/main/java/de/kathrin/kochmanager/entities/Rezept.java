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
    private String titel;
    @Column(name = "BESCHREIBUNG")
    private String beschreibung;
    @Column(name = "ZUTATEN_VOLLSTÄNDIG")
    boolean zutatVollstaendig;
    @OneToOne(cascade = {CascadeType.ALL})
    private ImageRezept imageRezept;
    @Column(name="url")
    private String url;



   /* public boolean lebensmittelVorraetig(List<Lebensmittel>lebensmittel) {

        zutatVollstaendig = false;

        zutaten.forEach((zutat)->{
            if(lebensmittel.contains(zutat.getLebensmittel())){
                for (Lebensmittel l:lebensmittel) {
                    if(l.equals(zutat.getLebensmittel())) {
                        if(zutat.getMenge().getMenge()>=l.getMenge().getMenge()){
                            zutatVollstaendig = true;
                        }else {
                            zutatVollstaendig = false;
                        }
                    }
                }
            }
        });

        return zutatVollstaendig;
    }*/
    public void addZutaten(Zutat zutat){
        zutaten.add(zutat);
    }
}
