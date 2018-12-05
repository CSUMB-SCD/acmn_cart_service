package freedomphones.cart_microservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import freedomphones.cart_microservice.business.Manager;

@RestController
public class CartController{
    @Autowired
    Manager manager;

    @PostMapping(value = "/addItem/{username}", produces="application/json")
    @ResponseBody
    public String addItem(@RequestBody String body, @PathVariable String username){
        return manager.addItem(body, username);
    }
    @ResponseBody
    @GetMapping(value = "/getCart/{username}", produces="application/json")
    public String addItem(@PathVariable String username){
        return manager.getCart(username);
    }
    @ResponseBody
    @GetMapping(value = "/deleteItem/{username}/{prod_id}", produces="application/json")
    public String deleteItem(@PathVariable String username, @PathVariable String prod_id){
        return manager.deleteItem(username, prod_id);
    }
}
