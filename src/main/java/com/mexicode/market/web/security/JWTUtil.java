package com.mexicode.market.web.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component /**Expreso que es un componente de Spring*/
public class JWTUtil {

    private  static final String KEY= "masterkey";

    /**Devuelvel Token en formato String*/
    public  String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails
                                         .getUsername())
                                         .setIssuedAt(new Date())
                                         .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
                                         .signWith(SignatureAlgorithm.HS256, KEY)
                                         .compact();
    }
   /**Valida que pertenezca a quien lo envio y ademas que no haya expirado*/
    public  boolean validateToken(String token, UserDetails userDetails){
        return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
    }

    /**Metodo para extraer el usuario del Token*/
    public  String extractUsername(String token){  //le paso el token
        return getClaims(token).getSubject();
    }
    /**Valida la expiracion del Token*/
    public  boolean isTokenExpired(String token){  //Le paso el token
        return getClaims(token)
                .getExpiration()
                .before(new Date());
    }

    /**Metodo auxiliar*/
    private Claims getClaims(String token){
        return  Jwts.parser()               //TRADUCE
                .setSigningKey(KEY)         //Incluyo la llave
                .parseClaimsJws(token)      //
                .getBody();
    }


}
