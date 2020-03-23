package de.kathrin.kochmanager.rest;

import de.kathrin.kochmanager.entities.Lebensmittel;
import de.kathrin.kochmanager.entities.Rezept;
import de.kathrin.kochmanager.entities.Zutat;
import de.kathrin.kochmanager.repos.Rezept.RezeptRepo;
import de.kathrin.kochmanager.repos.Zutat.ZutatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Zutat")
public class ZutatRestController {
    @Autowired
    ZutatRepo zutatRepo;

    @GetMapping
    public List<Zutat> getAllRezepte(){
        return zutatRepo.findAll();
    }

    @GetMapping("/{id}")
    public Zutat findById(@PathVariable("id") Long id) {
        return zutatRepo.findById(id).orElse(null);
    }

    @PostMapping
    public void saveNew(@RequestBody Zutat zutat){
        if(zutat.getId()!=null){
            throw new IllegalArgumentException("id must be null");
        }
        zutatRepo.save(zutat);
    }

    @PutMapping("/{id}")
    public Zutat saveExistRezept(@RequestBody Zutat zutat, @PathVariable("id")Long id){
        if(zutat.getId()!=null){
            if(!zutat.getId().equals(id)){
                throw new IllegalArgumentException("It isn't the same object.");
            }
        }else{
            zutat.setId(id);
        }
        return zutatRepo.save(zutat);

    }

    @DeleteMapping
    public void deleteAll(){
        zutatRepo.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        Optional<Zutat> zutatOpt = zutatRepo.findById(id);

        if (zutatOpt.isEmpty()) {
            throw new IllegalArgumentException("Trainer with id " + id + " does not exits");
        } else {
            zutatRepo.delete(zutatOpt.get());
        }

    }

}
