package com.pausiar.APICompleta.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        jdbc.execute("CREATE TABLE IF NOT EXISTS users (" +
                "username VARCHAR(50) NOT NULL PRIMARY KEY, " +
                "password VARCHAR(500) NOT NULL, " +
                "enabled BOOLEAN NOT NULL DEFAULT TRUE)");

        jdbc.execute("CREATE TABLE IF NOT EXISTS authorities (" +
                "username VARCHAR(50) NOT NULL, " +
                "authority VARCHAR(50) NOT NULL, " +
                "FOREIGN KEY (username) REFERENCES users(username))");

        // Insertar usuarios por defecto si no existen, o actualizar password si existen
        BCryptPasswordEncoder encoder = passwordEncoder();

        Integer pauCount = jdbc.queryForObject(
                "SELECT COUNT(*) FROM users WHERE username = 'pau'", Integer.class);
        if (pauCount == null || pauCount == 0) {
            jdbc.update("INSERT INTO users (username, password, enabled) VALUES (?, ?, true)",
                    "pau", encoder.encode("123"));
            jdbc.update("INSERT INTO authorities (username, authority) VALUES (?, ?)",
                    "pau", "ROLE_USER");
        } else {
            // Actualizar password por si el hash es incorrecto
            jdbc.update("UPDATE users SET password = ? WHERE username = 'pau'",
                    encoder.encode("123"));
        }

        Integer adminCount = jdbc.queryForObject(
                "SELECT COUNT(*) FROM users WHERE username = 'admin'", Integer.class);
        if (adminCount == null || adminCount == 0) {
            jdbc.update("INSERT INTO users (username, password, enabled) VALUES (?, ?, true)",
                    "admin", encoder.encode("admin"));
            jdbc.update("INSERT INTO authorities (username, authority) VALUES (?, ?)",
                    "admin", "ROLE_ADMIN");
        } else {
            jdbc.update("UPDATE users SET password = ? WHERE username = 'admin'",
                    encoder.encode("admin"));
        }

        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/register/").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.defaultSuccessUrl("/upload", true))
                .httpBasic(withDefaults())
                .build();
    }
}
