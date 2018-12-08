package freedomphones.cart_microservice.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freedomphones.cart_microservice.data.CartDbClient;

@Service
public class Manager{
    @Autowired
    CartDbClient cartDbClient;

    public String addItem(String body, String username){
        return cartDbClient.addItem(body,username);
    }
    public String getCart(String username){
        return cartDbClient.getCart(username);
    }
    public String deleteItem(String username, String prod_id){
        return cartDbClient.deleteItem(username, prod_id);
    }
    public String deleteItem(String username){
        return cartDbClient.clearCart(username);
    }
}