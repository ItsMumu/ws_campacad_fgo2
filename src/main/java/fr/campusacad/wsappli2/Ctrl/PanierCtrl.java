package fr.campusacad.wsappli2.Ctrl;

import fr.campusacad.wsappli2.DAO.RO.PanierRO;
import fr.campusacad.wsappli2.DAO.RO.PriceRO;
import fr.campusacad.wsappli2.services.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;

@RestController
@RequestMapping("/api/panier/")
public class PanierCtrl {


    @Autowired
    public PanierService service;

    public PanierCtrl() throws UnknownHostException {
    }

    @GetMapping("create/{id}")
    public void createPanier(@PathVariable("id")String id) throws Exception {
        try{
            service.createPanier(id);

        }catch(Exception e){
            throw new Exception("Création panier impossible");
        }
    }

    @GetMapping("add/{id}")
    public void addBookToPanier(@PathVariable("id")String id) throws Exception {
        try{
            service.addBookToPanier(id);

        }catch(Exception e){
            throw new Exception("Ajout panier impossible");
        }
    }
}
