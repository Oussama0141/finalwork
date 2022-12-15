package tn.esprit.kaddemspring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspring.model.Request;
import tn.esprit.kaddemspring.repository.RequestRepository;

import java.util.List;

@Service
public class RequestServicesImpl implements RequestServices{

    @Autowired
    RequestRepository requestRepository;

    public Request addRequest(Request request){
        return requestRepository.save(request);
    }

    public List<Request> findAllRequests(){
        return requestRepository.findAll();
    }

    public void deleteRequestById(Long id){
        requestRepository.deleteById(id);
    }
}
