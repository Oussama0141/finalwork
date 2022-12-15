package tn.esprit.kaddemspring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspring.model.Request;
import tn.esprit.kaddemspring.model.Utilisateur;
import tn.esprit.kaddemspring.repository.RequestRepository;
import tn.esprit.kaddemspring.services.RequestServices;
import tn.esprit.kaddemspring.services.UtilisateurServices;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/request")
public class RequestControllers {
    @Autowired
    RequestServices requestServices;



    @GetMapping("/all")
    public ResponseEntity<List<Request>> getAllRequests(){
        List<Request> requests = requestServices.findAllRequests();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Request> addRequest(@RequestBody Request request){

        Request newRequest = requestServices.addRequest(request);
        return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public void removeRequest (@PathVariable("id") Long id) {
        requestServices.deleteRequestById(id);
    }


}
