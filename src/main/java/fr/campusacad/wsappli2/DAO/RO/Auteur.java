package fr.campusacad.wsappli2.DAO.RO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
public class Auteur {

    private int autor_id;

    private String nom;

    private String prenom;

    private String age;
}
