package tn.esprit.kaddemspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Université implements Serializable {
    @Id
    private long idUniversite;
    private String nomUniversite;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> departementSet;



}
