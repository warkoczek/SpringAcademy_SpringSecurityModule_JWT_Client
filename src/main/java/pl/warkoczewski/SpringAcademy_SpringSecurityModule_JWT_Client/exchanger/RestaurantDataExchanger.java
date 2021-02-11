package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.exchanger;

import org.springframework.http.ResponseEntity;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.model.Restaurant;

public interface RestaurantDataExchanger {
    ResponseEntity<Restaurant[]> exchange();
}
