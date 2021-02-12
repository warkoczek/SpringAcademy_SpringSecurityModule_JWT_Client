package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.exchanger;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.model.Restaurant;

@Component
public class DefaultRestaurantDataExchanger implements RestaurantDataExchanger {

    @Override
    public ResponseEntity<Restaurant[]> getRestaurants() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange("http://localhost:8080/restaurants", HttpMethod.GET, getHttpEntity(), Restaurant[].class);

    }

    private HttpEntity getHttpEntity(){
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Authorization", getJwt(true));
        return new HttpEntity(headers);
    }
    private String getJwt(boolean isAdmin){
        Algorithm algorithm = Algorithm.HMAC512("eShVmYq3t6w9y$B&E)H@McQfTjWnZr4u7x!A%C*F-JaNdRgUkXp2s5v8y/B?E(G+");
        return "Bearer " + JWT.create().withClaim("admin", isAdmin).sign(algorithm);
    }
    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange("http://localhost:8080/addRestaurant", HttpMethod.POST, getHttpEntity(restaurant), Restaurant.class).getBody();
    }
    private HttpEntity getHttpEntity(Restaurant restaurant){
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Authorization", getJwt(true));
        return new HttpEntity(restaurant, headers);
    }
}
