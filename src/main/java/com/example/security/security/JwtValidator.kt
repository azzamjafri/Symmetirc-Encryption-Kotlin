package com.example.security.security


import com.example.security.model.JwtUser
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component


@Component
class JwtValidator {

    private var secret : String = "secret"

    fun validate(token: String) : JwtUser {

        val jwtUser = JwtUser()
        try {
            val body: Claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .body

            jwtUser.setUserName(body.subject)
            jwtUser.setId(java.lang.Long.parseLong(body["userId"].toString()))
            jwtUser.setRole(body.get("role").toString())
        }catch (e : Exception){
            println(e)
        }

        return jwtUser
    }
}



//  J unit test
//  rsa 512
// java 11 or 12
// public private key
// interface segreation
// unit test for boundary condition
// SSL transition 512B keys 128B keys encryption