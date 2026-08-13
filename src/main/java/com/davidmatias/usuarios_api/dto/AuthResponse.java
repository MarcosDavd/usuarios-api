package com.davidmatias.usuarios_api.dto;

public record AuthResponse(
        String token,
        String username,
        String rol
) {}