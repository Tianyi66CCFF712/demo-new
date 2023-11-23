package com.example.demonew.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String signKey = "lostinluotianyi";
//    public static SecretKey getSecretKey(){
//        return Keys.hmacShaKeyFor(signKey.getBytes());
//    }
    private static final Long expire = 43200000L;//24hours
//    SecretKey key = Jwts.SIG.HS256.key().build();
//    String jws = Jwts.builder().subject(signKey).signWith(key).compact();
    /**
     * 生成JWT令牌
     * @param claims JWT第二部分负载 payload 中存储的内容
     * @return
     */
//    //过时的jwt用法
    public static String generateJwt(Map<String, Object> claims){
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        return jwt;
    }
//    public static String generateJwt(Map<String, Object> claims){
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(expire))
//                .signWith(getSecretKey(),SignatureAlgorithm.HS256)
//                .compact();
//    }


    /**
     * 解析JWT令牌
     * @param jwt JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Claims parseJWT(String jwt){
        //                .verifyWith(signKey)
//                .build()
//                .parseSignedClaims(jwt);
        return Jwts.parser()
                .setSigningKey(signKey)
//                .build()//这是新加的
                .parseClaimsJws(jwt)
                .getBody();
    }
}
