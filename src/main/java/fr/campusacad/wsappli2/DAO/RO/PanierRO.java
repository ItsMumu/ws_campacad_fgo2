package fr.campusacad.wsappli2.DAO.RO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Document(collection = "panier")
public class PanierRO implements Serializable {


    private List<Livre> livre;
    private PriceRO prix;

    public PanierRO(){ }

    public PanierRO(List<Livre> livre, PriceRO prix){

        this.livre=livre;
        this.prix=prix;
    }




    public List<Livre> getLivre() {
        return livre;
    }

    public void setLivre(List<Livre> livre) {
        this.livre = livre;
    }

    public PriceRO getPrix() {
        return prix;
    }

    public void setPrix(PriceRO prix) {
        this.prix = prix;
    }
}
