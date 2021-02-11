package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.service;

import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    Optional<List<Restaurant>> showRestaurants();
}
