package tn.esprit.kaddemspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.kaddemspring.services.DetailsEquipeServices;

@CrossOrigin("*")
@RestController
@RequestMapping("/DetailsEquipe")
public class DetailsEquipeControllers {
    @Autowired
    public DetailsEquipeServices DetailsEquipeServices;
}
