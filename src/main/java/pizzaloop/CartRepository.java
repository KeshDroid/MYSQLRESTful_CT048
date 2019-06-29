package pizzaloop;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional

public interface CartRepository extends CrudRepository<CartOne, String> {

    List<CartOne> findByPizName (String pName);
    List<CartOne> deleteByPizName (String pName);

}
