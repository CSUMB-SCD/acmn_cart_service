package freedomphones.cart_microservice.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CartDbClient{
    public String addItem(String body, String username){
        final String uri = "https://freedomphones-zuul-svc.herokuapp.com/cart-db-service/addItem/{username}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(body, headers);
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        return restTemplate.postForObject(uri,entity, String.class, params);
    }
    public String deleteItem(String username, String prod_id){
        final String uri = "https://freedomphones-zuul-svc.herokuapp.com/cart-db-service/deleteItem/{username}/{prod_id}";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("prod_id", prod_id);
        return restTemplate.getForObject(uri, String.class, params);
    }
    public String getCart(String username){
        final String uri = "https://freedomphones-zuul-svc.herokuapp.com/cart-db-service/getCart/{username}";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        return restTemplate.getForObject(uri, String.class, params);
    }
}