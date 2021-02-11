package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.excahnger;

import org.springframework.http.ResponseEntity;

public interface RestaurantDataExchanger {
    ResponseEntity<String[]> exchange();
}
