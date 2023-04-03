package com.example.apiapp.Controller;

import com.example.apiapp.Model.AuthResponseDto;
import com.example.apiapp.Model.LoginRequestDto;
import com.example.apiapp.Model.RegisterRequestDto;
import com.example.apiapp.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto registerRequestDto) {
        return ResponseEntity.ok(authService.login(registerRequestDto));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto) {
        return ResponseEntity.ok(authService.register(registerRequestDto));
    }
}