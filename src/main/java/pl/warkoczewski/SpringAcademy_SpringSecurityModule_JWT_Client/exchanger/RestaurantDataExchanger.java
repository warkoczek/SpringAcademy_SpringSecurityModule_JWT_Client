package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.exchanger;

import org.springframework.http.ResponseEntity;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.model.Restaurant;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface RestaurantDataExchanger {
    ResponseEntity<Restaurant[]> getRestaurants() throws InvalidKeySpecException, NoSuchAlgorithmException;
    Restaurant addRestaurant() throws InvalidKeySpecException, NoSuchAlgorithmException;
}
