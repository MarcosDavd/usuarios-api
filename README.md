# Usuarios API

API REST en Java para registro y autenticacion de usuarios, usando JWT

## Tecnologias

- Java
- Spring Boot
- Spring Data JPA + Hibernate
- Spring Security + JWT (jjwt)
- PostgreSQL
- Maven

## Endpoints

| Método | Endpoint | Descripción | Body |
|---|---|---|---|
| POST | `/auth/register` | Registra un nuevo usuario | `username`, `email`, `password` |
| POST | `/auth/login` | Autentica y devuelve un JWT | `username`, `password` |

