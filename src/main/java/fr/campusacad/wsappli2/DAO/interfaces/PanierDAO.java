package fr.campusacad.wsappli2.DAO.interfaces;

import fr.campusacad.wsappli2.DAO.RO.PanierRO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface PanierDAO extends MongoRepository<PanierRO, String> {

    PanierRO findBy(String id);


}
