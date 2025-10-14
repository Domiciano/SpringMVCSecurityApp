package org.example.introspringboot.api.v1;

import org.example.introspringboot.api.v1.dto.AuthRequest;
import org.example.introspringboot.api.v1.dto.AuthResponse;
import org.example.introspringboot.security.CustomUserDetailService;
import org.example.introspringboot.security.CustomUserDetails;
import org.example.introspringboot.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthRestController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {

        //Proceso de autenticación
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        //Creación de token
        UserDetails userDetails = customUserDetailService.loadUserByUsername(request.getUsername());
        String jwt = jwtService.generateToken(userDetails);

        var response = new AuthResponse(jwt);
        return ResponseEntity.ok(response);
    }

}
