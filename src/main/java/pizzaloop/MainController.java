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
    Iterable<CartOne> getCartOne() {
        return cartRepository.findAll();
    }


    /* #Read Operation
     #URI to access this: http://localhost:8080/demo/cart*/
   /* @GetMapping(path="/cart")

    public @ResponseBody
    Iterable<Cart> getCart() {
        return cartRepository.findAll();
    }*/







    /*  #Read Operation based on Pizza Id
        #URI to access this: http://localhost:8080/demo/findByPizzaId?id=2 */

    @GetMapping(path = "/findByPizzaId")
    public @ResponseBody
    List<PizzaDetails> getPizzaById(@RequestParam Integer id) {
        return pizzaRepository.findByPizzaId(id);
    }

    @GetMapping(path = "findByPizName")
    public @ResponseBody
    List<CartOne> getCartBypName(@RequestParam String pName) {
        return cartRepository.findByPizName(pName);
    }



     /*  #Read Operation based on Pizza Id
        #URI to access this: http://localhost:8080/demo/qtyGetByPizzaId?id=2 */

  /*  @GetMapping(path="/qtyGetByPizName")
    public @ResponseBody
    List<Cart> qtyGetPizzaById(@RequestParam String pizName) {
        return cartRepository.qtyGetByPizName(pizName);
    }*/



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

    @GetMapping(path = "/addcart")

    public @ResponseBody
    String addNewCart(@RequestParam String pizName, @RequestParam Double price, @RequestParam Double total, @RequestParam Integer qty) {
        CartOne cartOne = new CartOne();
        cartOne.setPizName(pizName);
        cartOne.setPrice(price);
        cartOne.setTotal(total);
        cartOne.setQty(qty);
        cartRepository.save(cartOne);
        return SUCCESS;
    }

    /*  #Create Operation
        #URI to access this: http://localhost:8080/demo/add?name=VegiPizza&description=VegiSupreme&price=2500.75 */

  /*  @GetMapping(path="/qtyAdd")
    public @ResponseBody String addNewItem(@RequestParam Integer qty, @RequestParam Double tot, @RequestParam Double price) {
        Cart cart = new Cart();
        cart.setQty(qty);
        cart.setPrice(price);
        cart.setTot(tot);
        cartRepository.save(cart);
        return SUCCESS;
    }*/





    /*  #Delete Operation
        #URI to access this: http://localhost:8080/demo/deleteByPizzaId?id=2 */

    @GetMapping(path = "/deleteByPizzaId")
    public @ResponseBody
    List<PizzaDetails> deletePizzaById(@RequestParam Integer id) {
        return pizzaRepository.deleteByPizzaId(id);
    }

    @GetMapping(path = "/deleteByPizName")
    public @ResponseBody
    List<CartOne> deletePizByName(@RequestParam String pName) {
        return cartRepository.deleteByPizName(pName);
    }


     /*  #Delete Operation
        #URI to access this: http://localhost:8080/demo/qtyDeleteByPizzaId?id=2 */

  /*  @GetMapping(path="/qtydeleteByPizzaId")
    public @ResponseBody List<Cart> qtyDeletePizName(@RequestParam String pizName) {
        return cartRepository.qtyDeleteByPizName(pizName);
    }*/



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


    @GetMapping(path = "/updatecart")
    public @ResponseBody
    List<CartOne> updateCartOne(@RequestParam String pizName, @RequestParam Double price, @RequestParam Double total, @RequestParam Integer qty) {

        List<CartOne> cartOneList = cartRepository.findByPizName(pizName);
        if (!cartOneList.isEmpty()) {

            for (CartOne cartOne : cartOneList) {
                cartOne.setPizName(pizName);
                cartOne.setPrice(price);
                cartOne.setTotal(total);
                cartOne.setQty(qty);
                cartRepository.save(cartOne);
            }
        }
        return cartRepository.deleteByPizName(pizName);
    }
}






/*
    @GetMapping(path="/qtyAdd")
    public @ResponseBody
    List<Cart> updateCart(@RequestParam String pizName , @RequestParam Integer qty, @RequestParam Double tot, @RequestParam Double price) {

        List <Cart> cartList = cartRepository.qtyGetByPizName(pizName);
        if(!cartList.isEmpty()) {

            for(Cart cart: cartList) {
                cart.setQty(qty);
                cart.setPrice(price);
                cart.setTot(tot);

                cartRepository.save(cart);
            }
        } return cartRepository.qtyGetByPizName(pizName);



    }*/






