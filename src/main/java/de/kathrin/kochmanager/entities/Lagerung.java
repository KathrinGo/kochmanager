package de.kathrin.kochmanager.entities;

import de.kathrin.kochmanager.Exception.AnzahlKleinerNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LAGERUNG")
@Slf4j
public class Lagerung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @OneToMany(mappedBy = "lagerung",cascade = CascadeType.MERGE)
    private List<Lebensmittel> vorrat =new ArrayList<>();
    //private Map<Lebensmittel,Integer> inhalt = new HashMap<Lebensmittel, Integer>();


    public void lebensmittelHinzufuegen(Lebensmittel lebensmittel,int menge) throws AnzahlKleinerNull {
        Objects.nonNull(lebensmittel);
        if(menge<=0) {
            throw new AnzahlKleinerNull("Menge des Lebensmittel ist ung�ltig!");
        }
        if(vorrat.contains(lebensmittel)) {
            for (Lebensmittel l: vorrat) {
                if(l==lebensmittel){
                    l.mengeHinzufügen(menge);
                }
            }
        }else {
            lebensmittel.mengeHinzufügen(menge);
            vorrat.add(lebensmittel);

        }
    }

    public void lebensmittelRausnehmen(Lebensmittel lebensmittel, int menge) {
        Objects.nonNull(lebensmittel);
        if(vorrat.contains(lebensmittel)) {
            for (Lebensmittel l: vorrat) {
                if(l==lebensmittel){
                    if(l.getMenge().getMenge()>menge){
                        l.mengeWegnehmen(menge);
                    }else if(l.getMenge().getMenge()==menge){
                        vorrat.remove(lebensmittel);
                        lebensmittel.mengeWegnehmen(menge);
                    }
                    else{
                        log.info("Das gibt der Vorrat nicht her!");
                    }
                    break;
                }
            }
        }else{
            log.info("Das Lebensmittel ist gar nicht vorrätig");
        }
    }

}
