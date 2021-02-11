package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.exchanger;

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
    public ResponseEntity<Restaurant[]> exchange() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange("http://localhost:8080/restaurants", HttpMethod.GET, getHttpEntity(), Restaurant[].class);

    }
    private HttpEntity getHttpEntity(){
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Authorization", "Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkFkYW0gV2Fya29jemV3c2tpIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.u0QiE8J4cwZoeDdEruL7bNGxH7Nf5m6ZgZ-vWjxEvJ3v7mBzzSywgbUdog_wjaNS01TnICzh8k1IYdzl0ACF-w");
        return new HttpEntity(headers);
    }
}
