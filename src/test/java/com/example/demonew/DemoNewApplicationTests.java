package com.example.demonew;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoNewApplicationTests {
//
//    @Test
//public void textJJWT(){
//        Map<String,Object>claims=new HashMap<>();
//        claims.put("id",1);
//        claims.put("name","tom");
//        System.out.println("map里的claims是"+ claims);
//        String jwt=Jwts.builder()
//                .signWith(SignatureAlgorithm.HS256,"tianyi")
//                .setClaims(claims)
//                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
//                .compact();
//        System.out.println(jwt);
//    }
//    @Test
//    public void jiexi(){
//        Claims claims=Jwts.parser()
//                .setSigningKey("tianyi")
//                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5NTEyNzc3OH0.x6OPL1rJq9NkdWA1sm_9_4OXtBdcfqhqDLoDs_hadKg")
//                .getBody();
//            System.out.println(claims);
//    }
}
