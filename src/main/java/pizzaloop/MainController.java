package pizzaloop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private CartRepository cartRepository;

    private static final String SUCCESS = "Saved";

    /* #Read Operation
       #URI to access this: http://localhost:8080/demo/all*/
    @GetMapping(path = "/all")

    public @ResponseBody
    Iterable<PizzaDetails> getPizzaDetails() {
        return pizzaRepository.findAll();
    }


    @GetMapping(path = "/cartall")

    public @ResponseBody
    Iterable<Cart> getCart() { return cartRepository.findAll(); }


    /*  #Read Operation based on Pizza Id
        #URI to access this: http://localhost:8080/demo/findByPizzaId?id=2 */

    @GetMapping(path = "/findByPizzaId")
    public @ResponseBody
    List<PizzaDetails> getPizzaById(@RequestParam Integer id) {
        return pizzaRepository.findByPizzaId(id);
    }

    @GetMapping(path = "findByPizName")
    public @ResponseBody
    List<Cart> getCartByPizName(@RequestParam String pizName) {
        return cartRepository.findByPizName(pizName);
    }



    /*  #Create Operation
        #URI to access this: http://localhost:8080/demo/add?name=VegiPizza&description=VegiSupreme&price=2500.75 */

    @GetMapping(path = "/add")
    public @ResponseBody
    String addNewPizza(@RequestParam String name, @RequestParam String description, @RequestParam Double price) {
        PizzaDetails pizzaDetails = new PizzaDetails();
        pizzaDetails.setName(name);
        pizzaDetails.setDescription(description);
        pizzaDetails.setPrice(price);
        pizzaRepository.save(pizzaDetails);
        return SUCCESS;
    }


    /*  #Create Operation
        #URI to access this: http://localhost:8080/demo/addcart?pizName=VegiPizza*/

    @GetMapping(path = "/addcart")

    public @ResponseBody
    String addNewCart(@RequestParam String pizName, @RequestParam Double cPrice, @RequestParam Integer qty, @RequestParam Double total) {
       // System.out.println(pizName);
        //CartOne cartOne = new CartOne();
       // cartOne.setPizName(pizName);

        Cart cart = new Cart();
        cart.setPizName(pizName);
        cart.setcPrice(cPrice);
        cart.setQty(qty);
        cart.setTotal(total);
        cartRepository.save(cart);
        return SUCCESS;
    }



    /*  #Delete Operation
        #URI to access this: http://localhost:8080/demo/deleteByPizzaId?id=2 */

    @GetMapping(path = "/deleteByPizzaId")
    public @ResponseBody
    List<PizzaDetails> deletePizzaById(@RequestParam Integer id) {
        return pizzaRepository.deleteByPizzaId(id);
    }

    /*  #Delete Operation
       #URI to access this: http://localhost:8080/demo/deleteByPizName?pizName=kakss */
    @GetMapping(path = "/deleteByPizName")
    public @ResponseBody
    List<Cart> deleteByPizName(@RequestParam String pizName) {
        return cartRepository.deleteByPizName(pizName);
    }



    /*  #Update operation
        # URI to access this: http://localhost:8080/demo/update?id=1&name=updatedname&description=updated&price=1234.56 */

    @GetMapping(path = "/update")
    public @ResponseBody
    List<PizzaDetails> updatePizzaDetails(@RequestParam Integer id, @RequestParam String name, @RequestParam String description, @RequestParam Double price) {

        List<PizzaDetails> pizzaDetailsList = pizzaRepository.findByPizzaId(id);
        if (!pizzaDetailsList.isEmpty()) {

            for (PizzaDetails pizzaDetails : pizzaDetailsList) {
                pizzaDetails.setName(name);
                pizzaDetails.setDescription(description);
                pizzaDetails.setPrice(price);
                pizzaRepository.save(pizzaDetails);
            }
        }
        return pizzaRepository.findByPizzaId(id);
    }

    /*  #Update operation
       # URI to access this: http://localhost:8080/demo/updatecart?pizName=vegi */
    @GetMapping(path = "/updatecart")
    public @ResponseBody
    List<Cart> updateCartOne(@RequestParam String pizName, @RequestParam Double cPrice, @RequestParam Integer qty, @RequestParam Double total) {

        List<Cart> cartDetailsList = cartRepository.findByPizName(pizName);
        if (!cartDetailsList.isEmpty()) {

            for (Cart cartDetails: cartDetailsList){
                cartDetails.setPizName(pizName);
                cartDetails.setcPrice(cPrice);
                cartDetails.setQty(qty);
                cartDetails.setTotal(total);
                cartRepository.save(cartDetails);

            }
        }
        return cartRepository.findByPizName(pizName);
    }
}













