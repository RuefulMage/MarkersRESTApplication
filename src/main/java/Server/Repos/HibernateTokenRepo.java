package Server.Repos;

import Server.Models.Entities.Token;
import org.springframework.data.repository.CrudRepository;

public interface HibernateTokenRepo extends CrudRepository<Token, Integer> {
    Token findByValue(String value);

}
