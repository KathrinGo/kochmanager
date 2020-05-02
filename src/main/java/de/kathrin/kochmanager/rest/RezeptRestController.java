package de.kathrin.kochmanager.rest;

import de.kathrin.kochmanager.entities.Lebensmittel;
import de.kathrin.kochmanager.entities.Rezept;
import de.kathrin.kochmanager.repos.Lebensmittel.LebensmittelRepo;
import de.kathrin.kochmanager.repos.Rezept.RezeptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/Rezept")
public class RezeptRestController {
    @Autowired
    RezeptRepo rezeptRepo;

    @GetMapping
    public List<Rezept> getAllRezepte(){
        return rezeptRepo.findAll();
    }

    @GetMapping("/{id}")
    public Rezept findById(@PathVariable("id") Long id) {
        return rezeptRepo.findById(id).orElse(null);
    }

    @PostMapping
    public void saveNew(@RequestBody Rezept rezept){
        if(rezept.getId()!=null){
            throw new IllegalArgumentException("id must be null");
        }
        rezeptRepo.save(rezept);
    }

    @PutMapping("/{id}")
    public Rezept saveExistRezept(@RequestBody Rezept rezept, @PathVariable("id")Long id){
        if(rezept.getId()!=null){
            if(!rezept.getId().equals(id)){
                throw new IllegalArgumentException("It isn't the same object.");
            }
        }else{
            rezept.setId(id);
        }
        return rezeptRepo.save(rezept);

    }

    @DeleteMapping
    public void deleteAll(){
        rezeptRepo.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        Optional<Rezept> rezeptOpt = rezeptRepo.findById(id);

        if (rezeptOpt.isEmpty()) {
            throw new IllegalArgumentException("Trainer with id " + id + " does not exits");
        } else {
            rezeptRepo.delete(rezeptOpt.get());
        }

    }

}
