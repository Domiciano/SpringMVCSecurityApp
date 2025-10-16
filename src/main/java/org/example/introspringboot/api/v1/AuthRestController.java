package org.example.introspringboot.api.v1;

import org.example.introspringboot.api.v1.dto.AuthRequest;
import org.example.introspringboot.api.v1.dto.AuthResponse;
import org.example.introspringboot.security.CustomUserDetailService;
import org.example.introspringboot.security.JwtService;
import org.example.introspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthRestController {

    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {


        //TODO: Primero me debo autenticar y luego...



        UserDetails userDetails = customUserDetailService
                .loadUserByUsername(authRequest.getUsername());
        String token = jwtService.generateToken(userDetails);
        return ResponseEntity.status(200).body(new AuthResponse(token));
    }

}
