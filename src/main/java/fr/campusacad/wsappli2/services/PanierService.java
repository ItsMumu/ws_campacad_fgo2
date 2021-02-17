package fr.campusacad.wsappli2.services;

import com.google.gson.Gson;
import fr.campusacad.wsappli2.DAO.interfaces.PanierDAO;
import fr.campusacad.wsappli2.DAO.RO.Livre;
import fr.campusacad.wsappli2.DAO.RO.PanierRO;
import fr.campusacad.wsappli2.DAO.RO.PriceRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

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


    public String createPanier(String id) throws IOException {

        String url = "http://127.0.0.1:8081/api/book/get/"+id;


            StringBuffer response = requestAndGetResponse(url);
            Gson gson = new Gson();
            Livre livre = new Livre();
            livre = gson.fromJson(response.toString(), Livre.class);

            PanierRO panier = new PanierRO();
            List<Livre> booksList = new ArrayList<>();
            booksList.add(livre);
            panier.setLivre(booksList);
            panier.setPrix(new PriceRO(100));

            panierDao.save(panier);
            // print result
            return response.toString();


        //return panierToReturn;
    }

    public void addBookToPanier(String id){
        String url = "http://127.0.0.1:8081/api/book/add/"+id;

    }

}
