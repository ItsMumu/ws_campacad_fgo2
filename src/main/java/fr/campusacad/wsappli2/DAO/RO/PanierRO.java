package fr.campusacad.wsappli2.DAO.RO;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Document(collection = "panier")
public class PanierRO implements Serializable {


    @Id
    private ObjectId id;
    private List<Livre> livre;
    private PriceRO prix;
    private boolean isAcheté;

    public PanierRO(){
        this.livre= new ArrayList<Livre>();
    }

    public PanierRO(List<Livre> livre, PriceRO prix, boolean isAcheté){

        this.livre=livre;
        this.prix=prix;
        this.isAcheté = isAcheté;
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public boolean isAcheté() {
        return isAcheté;
    }

    public void setAcheté(boolean acheté) {
        isAcheté = acheté;
    }
}
