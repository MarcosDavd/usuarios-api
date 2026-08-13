package com.davidmatias.usuarios_api;

import com.davidmatias.usuarios_api.service.JwtService;
import com.davidmatias.usuarios_api.service.UserDetailsServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.davidmatias.usuarios_api.service.UsuarioService;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UsuariosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuariosApiApplication.class, args);
	}
	//PARA testear el service
	/*
	@Bean
    CommandLineRunner testRegistro(UsuarioService usuarioService) {
		return args -> {
			var usuario = usuarioService.registrarUsuario("davidpoma", "test@test.com", "miPasswordSegura123");
			System.out.println("Usuario creado con ID: " + usuario.getId());
			System.out.println("Password hasheada: " + usuario.getPassword());
		};
	}
	* */
	/* para testear el login de service
	@Bean
	CommandLineRunner testLogin(UsuarioService usuarioService) {
		return args -> {
			var usuario = usuarioService.login("davidpoma", "miPasswordSegura123");
			System.out.println("Login OK. Usuario: " + usuario.getUsername() + " | Rol: " + usuario.getRol());

			try {
				usuarioService.login("davidpoma", "contraseñaMala");
			} catch (IllegalArgumentException e) {
				System.out.println("Login rechazado : " + e.getMessage());
			}
		};

	 */
	/*@Bean
	CommandLineRunner testJwt(JwtService jwtService) {
		return args -> {
			String token = jwtService.generarToken("davidpoma", "USER");
			System.out.println("Token generado: " + token);

			String username = jwtService.extraerUsername(token);
			String rol = jwtService.extraerRol(token);
			System.out.println("Username extraído: " + username);
			System.out.println("Rol extraído: " + rol);

			boolean valido = jwtService.esTokenValido(token, "davidpoma");
			System.out.println("¿Token válido?: " + valido);
		};
	}
	*/
	/*
	@Bean
	CommandLineRunner testUserDetails(UserDetailsServiceImpl userDetailsService) {
		return args -> {
			var userDetails = userDetailsService.loadUserByUsername("davidpoma");
			System.out.println("Usuario cargado: " + userDetails.getUsername());
			System.out.println("Authorities: " + userDetails.getAuthorities());
		};
	}*/
}
