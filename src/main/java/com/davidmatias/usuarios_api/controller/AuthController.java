package com.davidmatias.usuarios_api.controller;

import com.davidmatias.usuarios_api.dto.AuthResponse;
import com.davidmatias.usuarios_api.dto.LoginRequest;
import com.davidmatias.usuarios_api.dto.RegisterRequest;
import com.davidmatias.usuarios_api.model.Usuario;
import com.davidmatias.usuarios_api.service.JwtService;
import com.davidmatias.usuarios_api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final JwtService jwtService;

    public AuthController(UsuarioService usuarioService, JwtService jwtService) {
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        try {
            Usuario usuario = usuarioService.registrarUsuario(
                    request.username(), request.email(), request.password());

            String token = jwtService.generarToken(usuario.getUsername(), usuario.getRol().name());
            return ResponseEntity.ok(new AuthResponse(token, usuario.getUsername(), usuario.getRol().name()));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        try {
            Usuario usuario = usuarioService.login(request.username(), request.password());

            String token = jwtService.generarToken(usuario.getUsername(), usuario.getRol().name());
            return ResponseEntity.ok(new AuthResponse(token, usuario.getUsername(), usuario.getRol().name()));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}