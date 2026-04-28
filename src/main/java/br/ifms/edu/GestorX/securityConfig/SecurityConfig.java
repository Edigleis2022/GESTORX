package br.ifms.edu.GestorX.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // 🔐 Criptografia de senha
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 🔐 Configuração de segurança (VERSÃO MODERNA)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // 🔥 Desativa CSRF (API REST)
                .csrf(csrf -> csrf.disable())

                // 🔥 Permite H2 Console
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))

                // 🔐 Regras de acesso
                .authorizeHttpRequests(auth -> auth

                        // 🔓 liberar cadastro inicial
                        .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()

                        // 🔓 Rotas públicas
                        .requestMatchers("/auth/**", "/h2-console/**").permitAll()

                        // 🔐 ADMIN
                        .requestMatchers("/usuarios/**").hasRole("ADMIN")

                        // 🔐 ADMIN + FUNCIONARIO
                        .requestMatchers("/produtos/**").hasAnyRole("ADMIN", "FUNCIONARIO")
                        .requestMatchers("/estoque/**").hasAnyRole("ADMIN", "FUNCIONARIO")
                        .requestMatchers("/movimentos/**").hasAnyRole("ADMIN", "FUNCIONARIO")

                        // 🔒 Qualquer outra precisa login
                        .anyRequest().authenticated())

                // 🔐 Basic Auth (para testes no Thunder Client)
                .httpBasic(httpBasic -> {
                })

                .build();
    }

}