package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

@Service
public class ClientJwtServiceImpl implements ClientJwtService{
    @Override
    public String getJwt(boolean isAdmin) {
        Algorithm algorithm = Algorithm.HMAC512("eShVmYq3t6w9y$B&E)H@McQfTjWnZr4u7x!A%C*F-JaNdRgUkXp2s5v8y/B?E(G+");
        return "Bearer " + JWT.create().withClaim("admin", isAdmin).sign(algorithm);
    }
}
