package fr.campusacad.wsappli2.DAO.RO;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
public class Livre implements Serializable {

    private int id;
    private String nom;
    private Auteur auteur;

}
