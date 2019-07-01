package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CartRepository extends CrudRepository <Cart, String>{
    List<Cart> findByPizName (String pizName);
    List<Cart> deleteByPizName (String pizName);
}
