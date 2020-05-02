package de.kathrin.kochmanager.rest;

import de.kathrin.kochmanager.entities.Lebensmittel;
import de.kathrin.kochmanager.repos.Lebensmittel.LebensmittelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Diese Klasse setzt die Rest Anfragen um. Mit GET, POST; POST DELETE.
//Anfragen an die DB, Verändern, Anlegen, Löschen
@RestController
@CrossOrigin
@RequestMapping("/api/Lebensmittel")
public class LebensmittelRestController {
    @Autowired
    LebensmittelRepo lebensmittelRepo;

    @GetMapping
    public List<Lebensmittel>getAllLebensmittel(){
        return lebensmittelRepo.findAll();
    }

    @GetMapping("/{id}")
    public Lebensmittel findById(@PathVariable("id") Long id) {
        return lebensmittelRepo.findById(id).orElse(null);
    }

    @PostMapping
    public void saveNew(@RequestBody Lebensmittel lebensmittel){
        if(lebensmittel.getId()!=null){
            throw new IllegalArgumentException("id must be null");
        }
        lebensmittelRepo.save(lebensmittel);
    }

    @PutMapping("/{id}")
    public Lebensmittel saveExisting(@RequestBody Lebensmittel lebensmittel, @PathVariable("id") Long id){
        if (lebensmittel.getId()!=null) {
            if (!lebensmittel.getId().equals(id)) {
                throw new IllegalArgumentException("ids of url and object do not match");
            }
        } else {
            lebensmittel.setId(id);
        }
        return lebensmittelRepo.save(lebensmittel);

    }

    @DeleteMapping
    public void deleteAll(){
        lebensmittelRepo.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        Optional<Lebensmittel> lebensmittelOpt = lebensmittelRepo.findById(id);

        if (lebensmittelOpt.isEmpty()) {
            throw new IllegalArgumentException("Lebensmittel with id " + id + " does not exits");
        } else {
            lebensmittelRepo.delete(lebensmittelOpt.get());
        }

    }



}
