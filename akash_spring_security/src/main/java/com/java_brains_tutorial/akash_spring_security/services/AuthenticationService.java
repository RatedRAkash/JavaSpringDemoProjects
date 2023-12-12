package com.java_brains_tutorial.akash_spring_security.services;

import com.java_brains_tutorial.akash_spring_security.config.JwtUtilService;
import com.java_brains_tutorial.akash_spring_security.dto.AuthenticationRequest;
import com.java_brains_tutorial.akash_spring_security.dto.AuthenticationResponse;
import com.java_brains_tutorial.akash_spring_security.dto.RegisterRequest;
import com.java_brains_tutorial.akash_spring_security.models.User;
import com.java_brains_tutorial.akash_spring_security.repositories.UserRepository;
import com.java_brains_tutorial.akash_spring_security.roles.CustomUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtUtilService jwtUtilService;

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(CustomUserRole.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtUtilService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtUtilService.generateToken(user);

        return AuthenticationResponse.builder()
                        .token(jwtToken)
                        .build();
    }
}
