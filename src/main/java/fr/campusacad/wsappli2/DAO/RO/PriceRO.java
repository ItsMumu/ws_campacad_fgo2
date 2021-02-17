package fr.campusacad.wsappli2.DAO.RO;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Component
public class PriceRO {

    private int prix;

    public PriceRO(){}

    public PriceRO(int prix){
        this.prix = prix;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
