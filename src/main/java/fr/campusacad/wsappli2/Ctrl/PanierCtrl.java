package fr.campusacad.wsappli2.Ctrl;

import com.google.gson.*;
import fr.campusacad.wsappli2.DAO.RO.Livre;
import fr.campusacad.wsappli2.DAO.RO.PanierRO;
import fr.campusacad.wsappli2.DAO.RO.PriceRO;
import fr.campusacad.wsappli2.services.PanierService;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/api/panier/")
public class PanierCtrl {


    @Autowired
    public PanierService service;

    public PanierCtrl() throws UnknownHostException {
    }


    @PostMapping("create")
    public void createPanier(@RequestBody String livres) throws IOException, JSONException {
//JsonObject jsonObject = new JsonParser().parse(object).getAsJsonObject();
        //String result = jsonObject.get("livre").getAsString();
        //service.createPanier2(jsonObject);
        Gson g = new Gson();
        JsonObject jsonObject = g.fromJson(livres, JsonObject.class);
        service.createPanier(jsonObject);
    }

    @GetMapping("validate/{id}")
    public void validatePanier(@PathVariable("id") String id){

        service.validatePanier(service.getPanier(id));
    }

}
