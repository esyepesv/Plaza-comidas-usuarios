package com.users.users.application.auth;

import com.users.users.domain.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JwtServiceTest {

    @InjectMocks
    private JwtService jwtService;

    @Mock
    private UserDetails userDetails;

    private final String TEST_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiQURNSU4iLCJpZCI6MSwic3ViIjoic3RpdmVuQHllcGVzLmNvbSIsImlhdCI6MTY5MjIxODY4OSwiZXhwIjoxNjkyMzA1MDg5fQ.bmrCSB5BK2pBKWNX-3RvCTJBMlCSzDrODIhjHy4l1c0";

    @Test
    void extractUsername() {
        String extractedUsername = jwtService.extractUsername(TEST_TOKEN);

        assertEquals("stiven@yepes.com", extractedUsername);
    }

    @Test
    void extractRole() {
        String extractedRole = jwtService.extractRole(TEST_TOKEN);

        assertEquals("ADMIN", extractedRole);
    }

    @Test
    void extractId() {
        Long extractedId = jwtService.extractId(TEST_TOKEN);

        assertEquals(1, extractedId);
    }

    @Test
    void isTokenValid() {
        String validToken = generateValidToken();
        when(userDetails.getUsername()).thenReturn("stiven@yepes.com");

        assertTrue(jwtService.isTokenValid(validToken, userDetails));
    }

    @Test
    void extractAllClaims() {
        String token = generateValidToken();

        Claims claims = jwtService.extractAllClaims(token);

        assertNotNull(claims);
        assertEquals("stiven@yepes.com", claims.getSubject());
    }

    private String generateValidToken() {
        return Jwts.builder()
                .setSubject("stiven@yepes.com")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(jwtService.getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

}