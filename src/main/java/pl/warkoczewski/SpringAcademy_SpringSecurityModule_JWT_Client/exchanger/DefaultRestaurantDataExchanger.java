package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.exchanger;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.model.Restaurant;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.service.ClientJwtService;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Component
public class DefaultRestaurantDataExchanger implements RestaurantDataExchanger {
    private final ClientJwtService clientJwtService;

    public DefaultRestaurantDataExchanger(ClientJwtService clientJwtService) {
        this.clientJwtService = clientJwtService;
    }

    @Override
    public ResponseEntity<Restaurant[]> getRestaurants() throws InvalidKeySpecException, NoSuchAlgorithmException {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange("http://localhost:8080/restaurants", HttpMethod.GET, getHttpEntity(), Restaurant[].class);

    }
    private HttpEntity getHttpEntity() throws InvalidKeySpecException, NoSuchAlgorithmException {
        MultiValueMap<String, String> headers = new HttpHeaders();
        String jwt = clientJwtService.getJsonWebToken(true);
        headers.add("Authorization", jwt);
        return new HttpEntity(headers);
    }
    @Override
    public Restaurant addRestaurant() throws InvalidKeySpecException, NoSuchAlgorithmException {
        Restaurant restaurant = new Restaurant("Red Lobster", "Berlin");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange("http://localhost:8080/addRestaurant", HttpMethod.POST, getHttpEntity(restaurant), Restaurant.class).getBody();
    }
    private HttpEntity getHttpEntity(Restaurant restaurant) throws InvalidKeySpecException, NoSuchAlgorithmException {
        MultiValueMap<String, String> headers = new HttpHeaders();
        String jwt = clientJwtService.getJsonWebToken(true);
        headers.add("Authorization", jwt);
        return new HttpEntity(restaurant, headers);
    }
}
