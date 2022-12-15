package tn.esprit.kaddemspring.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspring.model.*;
import tn.esprit.kaddemspring.repository.EquipeRepository;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class EquipeServicesImpl implements EquipeServices {
    @Autowired
    private EquipeRepository EquipeRepository;
    @Autowired
    private DetailsEquipeServices DetailsEquipeServices;

    @Override
    public Equipe addEquipe(Equipe Equipe){
        DetailsEquipe detailsEquipe = Equipe.getDetailsequipe();
        if(detailsEquipe != null ){
            detailsEquipe = DetailsEquipeServices.addDetailsE(detailsEquipe);}
        Equipe.setDetailsequipe(detailsEquipe);

        return EquipeRepository.save(Equipe);
    }

    @Override
    public List<Equipe> findAllEquipes(){
        return (List<Equipe>) EquipeRepository.findAll();
    }

    @Override
    public void deleteEquipeById(Long id) {
        EquipeRepository.deleteById(id);
        Equipe newEquipe = this.GetEquipeById(id);
        DetailsEquipe detailsEquipe = DetailsEquipeServices.GetDetailsEquipeById(newEquipe.getIdEquipe());
      if(detailsEquipe != null)
        DetailsEquipeServices.deleteDetailsEquipeById(detailsEquipe.getIdDetailsEquipe());
    }

    @Override
    public Equipe UpdateEquipe(Equipe Equipe) {
        DetailsEquipe detailsEquipe = Equipe.getDetailsequipe();
        if(detailsEquipe != null) {
            detailsEquipe = DetailsEquipeServices.UpdateDetailsEquipe(detailsEquipe);

            Equipe.setDetailsequipe(detailsEquipe);
        }
        return EquipeRepository.save(Equipe);
    }
    @Override
    public Equipe GetEquipeById(Long id) {
        return EquipeRepository.findById(id).orElse(null);
    }


    @Override
    public void faireEvoluerEquipes(){
        int a =0;
        float res =0;
        List<Equipe> Equipes = this.findAllEquipes();
        for (Equipe eq : Equipes) {
            if(!eq.getNiveau().equals(Niveau.Expert) ){
                if(eq.getEtudiantSet().size()>2){
                    for (Etudiant x : eq.getEtudiantSet()) {
                        int t=0;

                        for (Contrat y : x.getContratSet()){
                            if(t==0){
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-DD");

                            try {
                                Date dateAvant = sdf.parse(y.getDateDebutC().toString());
                                LocalDate todaysDate = LocalDate.now();
                                Date dateApres = sdf.parse(todaysDate.toString());
                                long diff = dateApres.getTime() - dateAvant.getTime();
                                 res = (diff / (1000*60*60*24));
                                System.out.println(res);

                                System.out.println("Nombre de jours entre les deux dates est: "+res);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if(res>365){
                                t=1;
                                a++;
                            }
                        }}
                    }
            }}
            System.out.println(a);
            if  (a>2){
            if(eq.getNiveau().equals(Niveau.Senior)) {
                eq.setNiveau(Niveau.Expert);
            }
            if(eq.getNiveau().equals(Niveau.Junior)) {
                eq.setNiveau(Niveau.Senior);
            }
            EquipeRepository.save(eq);
        }}

    }


}
