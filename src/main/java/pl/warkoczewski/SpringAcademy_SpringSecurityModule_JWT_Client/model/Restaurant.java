package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurant {
    private String name;
    private String city;
}
