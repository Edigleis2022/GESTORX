package br.ifms.edu.GestorX.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            // 🔥 Desativa CSRF (necessário pro H2)
            .csrf(csrf -> csrf.disable())

            // 🔥 Libera rotas
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**", "/usuarios/**", "/h2-console/**").permitAll()
                .anyRequest().authenticated()
            )

            // 🔥 Permite H2 abrir em frame (ESSENCIAL)
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))

            .build();
    }
}
