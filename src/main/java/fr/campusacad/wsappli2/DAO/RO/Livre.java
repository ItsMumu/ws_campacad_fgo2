package fr.campusacad.wsappli2.DAO.RO;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
public class Livre implements Serializable {

    private int id;
    private String nom;
    private Auteur auteur;
    private int stock;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
