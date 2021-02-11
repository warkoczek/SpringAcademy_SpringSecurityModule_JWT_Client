package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.excahnger.RestaurantDataExchanger;

import java.util.stream.Stream;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantDataExchanger restaurantDataExchanger;

    public RestaurantServiceImpl(RestaurantDataExchanger restaurantDataExchanger) {
        this.restaurantDataExchanger = restaurantDataExchanger;
    }

    @Override
    public void showRestaurants() {
        String[] body = restaurantDataExchanger.exchange().getBody();
        Stream.of(body).forEach(System.out::println);
    }
}
