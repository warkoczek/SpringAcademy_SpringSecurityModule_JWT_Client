package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.controller;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.service.RestaurantService;

@Controller
public class RestaurantClientController {
    private final RestaurantService restaurantService;

    public RestaurantClientController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void printRestaurants(){
        restaurantService.showRestaurants();
    }
}
