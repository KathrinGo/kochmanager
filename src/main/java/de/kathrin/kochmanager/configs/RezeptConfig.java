package de.kathrin.kochmanager.configs;

import de.kathrin.kochmanager.entities.Lebensmittel;
import de.kathrin.kochmanager.entities.Rezept;
import de.kathrin.kochmanager.entities.Zutat;
import de.kathrin.kochmanager.repos.Lebensmittel.LebensmittelRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@Slf4j
public class RezeptConfig {
   /* @Value("#{zutatEi}")
    private Zutat zutatEi;
    @Value("#{zutatButter}")
    private Zutat zutatButter;
    @Value("#{zutatMilch}")
    private Zutat zutatMilch;
    @Value("#{zutatApfel}")
    private Zutat zutatApfel;

    @Bean
    public Rezept rezeptSpiegelei(){
        Rezept rezept = new Rezept();
        rezept.setTitle("Spiegelei");
        rezept.addZutaten(zutatButter);
        rezept.addZutaten(zutatEi);
        rezept.setBeschreibung("1.Heize die Pfanne mit Butter vor. 2.Tue die Eier in die Pfanne und warte, bis sie gar sind.");
        return rezept;
    }
    @Bean
    public Rezept rezeptRuehrei(){
        Rezept rezept = new Rezept();
        rezept.setTitle("Ruehrei");
        rezept.setBeschreibung("1.Heize die Pfanne mit Butter vor. 2.Vermenge Ei und Milch und würze mit Salz und Pfeffer. 3.Tue die Eier und Milchmasse in die Pfanne und warte, bis sie gar sind.");
        return rezept;
    }

    @Bean
    public Rezept rezeptApfelmus(){
        Rezept rezept = new Rezept();
        rezept.setTitle("Apfelmus");
        rezept.addZutaten(zutatApfel);
        rezept.setBeschreibung("1.Pürieren sie den Apfel zu einem Muus.");
        return rezept;
    }
*/
}
