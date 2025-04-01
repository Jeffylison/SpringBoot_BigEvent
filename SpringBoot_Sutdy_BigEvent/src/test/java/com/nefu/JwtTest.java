package com.nefu;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "七海");
        //生成JWT
        String token = JWT.create()
                .withClaim("user", claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))//添加过期时间
                .sign(Algorithm.HMAC256("Jeffylison"));//指定算法配置密钥

        System.out.println(token);
    }

//    @Test
//    public void testParse() {
//        //模拟传递token
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuS4g-a1tyJ9LCJleHAiOjE3NDI1MTI4NTF9.bdiLaHUf46S_MkcWHJMrpnxiuUcvTqOs2oZKd02rWJs";
//
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("Jeffylison")).build();
//
//        DecodedJWT decodedJWT = jwtVerifier.verify(token);//验证token，生成解析后的JWT对象
//        Map<String, Claim> claims = decodedJWT.getClaims();
//        System.out.println(claims.get("user"));
//    }
}
