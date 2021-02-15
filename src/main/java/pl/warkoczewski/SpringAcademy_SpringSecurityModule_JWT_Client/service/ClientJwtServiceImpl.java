package pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule_JWT_Client.util.SecurityConstants;

import java.io.StringReader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

@Service
public class ClientJwtServiceImpl implements ClientJwtService{

    @Override
    public String getJsonWebToken(boolean isAdmin) throws InvalidKeySpecException, NoSuchAlgorithmException {
       /* Algorithm algorithm = Algorithm.HMAC512("eShVmYq3t6w9y$B&E)H@McQfTjWnZr4u7x!A%C*F-JaNdRgUkXp2s5v8y/B?E(G+");
        return "Bearer " + JWT.create().withClaim("admin", isAdmin).sign(algorithm);*/
        Algorithm algorithm = buildJwtAlgorithm();
       return "Bearer " + JWT.create().withClaim("admin", isAdmin).sign(algorithm);
    }

    private Algorithm buildJwtAlgorithm() throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] publicKeyBytes = SecurityConstants.PUBLIC_KEY.getBytes();
        RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
        byte[] privateKeyBytes = SecurityConstants.PRIVATE_KEY.getBytes();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(new X509EncodedKeySpec(privateKeyBytes));
        Algorithm algorithm = Algorithm.RSA512(publicKey, privateKey);
        return algorithm;

    }
}
