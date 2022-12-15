package tn.esprit.kaddemspring.services;

import tn.esprit.kaddemspring.model.Request;
import tn.esprit.kaddemspring.model.Utilisateur;

import java.util.List;

public interface RequestServices {

    Request addRequest(Request request);

    List<Request> findAllRequests();

    void deleteRequestById(Long id);

}
