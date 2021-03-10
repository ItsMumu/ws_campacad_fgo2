package fr.campusacad.wsappli2.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import fr.campusacad.wsappli2.DAO.interfaces.PanierDAO;
import fr.campusacad.wsappli2.DAO.RO.Livre;
import fr.campusacad.wsappli2.DAO.RO.PanierRO;
import fr.campusacad.wsappli2.DAO.RO.PriceRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PanierService {



    @Autowired
    private PanierDAO panierDao;

    private static final String USER_AGENT = "Mozilla/5.0";

    public StringBuffer requestAndGetResponse(String url) throws IOException {
        StringBuffer response = new StringBuffer();
        URL obj = new URL(url);
        HttpURLConnection httpConnection = (HttpURLConnection) obj
                .openConnection();

        httpConnection.setRequestMethod("GET");

        httpConnection.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = httpConnection.getResponseCode();
        if (responseCode == 200) {

            BufferedReader responseReader = new BufferedReader(new InputStreamReader(
                    httpConnection.getInputStream()));

            String responseLine;


            while ((responseLine = responseReader.readLine()) != null) {
                response.append(responseLine + "\n");
            }
            responseReader.close();
        }

        return response;
    }


    public void createPanier(JsonObject json) throws IOException {

        List<Livre> booksList = new ArrayList<>();
        for (int i = 1; i <= json.size() ; i++){
            System.out.println("test :"+json.get("livre"+i));
            String url = "http://127.0.0.1:8081/api/book/get/"+(json.get("livre"+i));
            StringBuffer response = requestAndGetResponse(url);

            Gson gson = new Gson();
            Livre livre = new Livre();
            livre = gson.fromJson(response.toString(), Livre.class);

            PanierRO panier = new PanierRO();
            if(livre != null)
            booksList.add(livre);
        }

        PanierRO panier = new PanierRO();

        panier.setLivre(booksList);
        panier.setPrix(new PriceRO(100));
        panierDao.save(panier);


    }

public void validatePanier (PanierRO panier) {
        Gson gson = new Gson();
        List<Integer> listOfId = new ArrayList<>();
        for(int i=0; i<panier.getLivre().size(); i++){
            listOfId.add(panier.getLivre().get(i).getId());
    }
        String jsonString = gson.toJson(listOfId);
            try (ZContext context = new ZContext()) {
                // Socket to talk to clients
                ZMQ.Socket socket = context.createSocket(SocketType.REQ);
                socket.connect("tcp://*:5555");
                String request = "VALIDATE_"+jsonString;

                socket.send(request.getBytes(ZMQ.CHARSET), 0);
                byte[] reply = socket.recv(0);
                if(new String(reply) != null && new String(reply).equals("PANIER_VALIDE")){
                    panier.setAcheté(true);
                    updatePanier(panier);
                }



    }
}
public void updatePanier(PanierRO panier){
    panierDao.save(panier);
}
public PanierRO getPanier(String id){
    Optional<PanierRO> result =  panierDao.findById(id);
        if(result != null){
            return result.get();
        }
    return null;
}

}
