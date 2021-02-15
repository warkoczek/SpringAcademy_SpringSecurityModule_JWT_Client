package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface ClientJwtService {
    String getJsonWebToken(boolean isAdmin) throws InvalidKeySpecException, NoSuchAlgorithmException;
}
