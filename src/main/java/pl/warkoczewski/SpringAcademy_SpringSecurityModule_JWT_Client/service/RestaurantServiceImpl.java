package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.exchanger.RestaurantDataExchanger;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.model.Restaurant;

import java.util.stream.Stream;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantDataExchanger restaurantDataExchanger;

    public RestaurantServiceImpl(RestaurantDataExchanger restaurantDataExchanger) {
        this.restaurantDataExchanger = restaurantDataExchanger;
    }

    @Override
    public void showRestaurants() {
        Restaurant[] body = restaurantDataExchanger.exchange().getBody();
        Stream.of(body).forEach(System.out::println);
    }
}
