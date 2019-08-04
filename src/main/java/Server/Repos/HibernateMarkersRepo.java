package Server.Repos;


import Server.Models.Entities.Marker;
import Server.Models.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HibernateMarkersRepo extends CrudRepository<Marker,Integer> {
    List<Marker> findAll();
    List<Marker> findByUser(User user);
}
