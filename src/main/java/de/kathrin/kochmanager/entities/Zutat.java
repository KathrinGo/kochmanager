package de.kathrin.kochmanager.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ZUTAT")
public class Zutat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @JoinColumn(name = "ID_LEBENSMITTEL")
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Lebensmittel lebensmittel;
    @JoinColumn(name = "MENGE_REZEPT")
    @OneToOne(cascade = {CascadeType.ALL})
    private Menge menge;
    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_REZEPT")
    Rezept rezept;



}
