package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.excahnger;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class DefaultRestaurantDataExchanger implements RestaurantDataExchanger {
    @Override
    public ResponseEntity<String[]> exchange() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange("http://localhost:8080/restaurants", HttpMethod.GET, getHttpEntity(), String[].class);

    }
    private HttpEntity getHttpEntity(){
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c");
        return new HttpEntity(headers);
    }
}
