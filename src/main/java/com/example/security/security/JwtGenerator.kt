package com.example.security.security


import com.example.security.model.JwtUser
import org.springframework.stereotype.Component
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm


@Component
class JwtGenerator {

    fun generate(jwtUser: JwtUser): String {

        val claims = Jwts.claims()
                .setSubject(jwtUser.getUserName())
        claims["userId"] = jwtUser.getId().toString()
        claims["role"] = jwtUser.getRole()


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "secret")
                .compact()
    }


}
