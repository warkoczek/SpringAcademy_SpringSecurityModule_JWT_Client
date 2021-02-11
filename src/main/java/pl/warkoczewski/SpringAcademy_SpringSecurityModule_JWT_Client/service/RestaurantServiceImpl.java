package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.exchanger.RestaurantDataExchanger;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.model.Restaurant;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantDataExchanger restaurantDataExchanger;

    public RestaurantServiceImpl(RestaurantDataExchanger restaurantDataExchanger) {
        this.restaurantDataExchanger = restaurantDataExchanger;
    }

    @Override
    public Optional<List<Restaurant>> showRestaurants() {
        Restaurant[] body = restaurantDataExchanger.exchange().getBody();
        if(body == null){
            return Optional.empty();
        }
        return Optional.of(Stream.of(body).collect(Collectors.toList()));
        //Stream.of(body).forEach(System.out::println);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void printRestaurantsOut(){
        showRestaurants().ifPresent(System.out::println);
    }
}
