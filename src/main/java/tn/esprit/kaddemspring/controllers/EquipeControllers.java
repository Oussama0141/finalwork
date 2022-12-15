package tn.esprit.kaddemspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspring.model.Contrat;
import tn.esprit.kaddemspring.model.Equipe;
import tn.esprit.kaddemspring.services.EquipeServices;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Equipe")
public class EquipeControllers {
    @Autowired
    public EquipeServices EquipeServices;

    @GetMapping("/all")
    public ResponseEntity<List<Equipe>> getAllEquipes(){
        List<Equipe> Equipes = EquipeServices.findAllEquipes();
        return new ResponseEntity<>(Equipes, HttpStatus.OK);
    }

    /******************************************************add contracts***********************************************/
    /*here weexpecting the whole contract object which is going to be in json format that we're gonna expecting it coming
    from the user*/
    @PostMapping("/add")
    public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe equipe){
        Equipe newEquipe = EquipeServices.addEquipe(equipe);
        return new ResponseEntity<>(newEquipe, HttpStatus.CREATED);
    }
    /******************************************************update contract***********************************************/
    @PutMapping("/update")
    public ResponseEntity<Equipe> updateContratss(@RequestBody Equipe equipe){
        Equipe ModifiedEquipe = EquipeServices.UpdateEquipe(equipe);
        return new ResponseEntity<>(ModifiedEquipe, HttpStatus.OK);
    }
    @DeleteMapping("/deletecontract/{id}")
    public void removeEquipe(@PathVariable("id") Long id) {
        EquipeServices.deleteEquipeById(id);
    }

    @GetMapping("/retrievecontract/{id}")
    public Equipe Retrievecontract(@PathVariable("id") Long id) {
        return EquipeServices.GetEquipeById(id);
    }




}
