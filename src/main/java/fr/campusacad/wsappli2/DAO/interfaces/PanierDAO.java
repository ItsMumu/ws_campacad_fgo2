package fr.campusacad.wsappli2.DAO.interfaces;

import fr.campusacad.wsappli2.DAO.RO.PanierRO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
@Repository
public interface PanierDAO extends MongoRepository<PanierRO, String> {


    Optional<PanierRO> findById(String id);


}
