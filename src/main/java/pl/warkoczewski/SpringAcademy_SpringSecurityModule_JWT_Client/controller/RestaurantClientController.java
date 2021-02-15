package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.controller;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.model.Restaurant;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.service.RestaurantService;

import java.util.List;

@RestController
public class RestaurantClientController {
    private final RestaurantService restaurantService;

    public RestaurantClientController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> printRestaurants(){
        return restaurantService.showRestaurants()
                .map(restaurants -> new ResponseEntity<>(restaurants, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    /*
    @PostMapping("/addRestaurant")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant){
        return new ResponseEntity<>(restaurantService.addRestaurant(restaurant), HttpStatus.CREATED);
    }*/
}
