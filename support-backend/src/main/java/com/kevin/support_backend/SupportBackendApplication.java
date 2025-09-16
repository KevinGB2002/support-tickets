package com.kevin.support_backend;

import com.kevin.support_backend.model.Ticket;
import com.kevin.support_backend.model.User;
import com.kevin.support_backend.repository.TicketRepository;
import com.kevin.support_backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SupportBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupportBackendApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner initData(UserRepository userRepository, TicketRepository ticketRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            User user1 = new User();
            user1.setUsername("kevin");
            user1.setPassword("12345"); // 🔓 sin encriptar
            user1.setEmail("kevin@example.com");
            userRepository.save(user1);

            User user2 = new User();
            user2.setUsername("admin");
            user2.setPassword(passwordEncoder.encode("admin"));
            user2.setEmail("admin@example.com");
            userRepository.save(user2);

            Ticket t1 = new Ticket();
            t1.setTitle("Error en login");
            t1.setDescription("No puedo iniciar sesión");
            t1.setStatus("ABIERTO");
            t1.setRequester(user1);
            t1.setAssignee(user2);
            ticketRepository.save(t1);

            Ticket t2 = new Ticket();
            t2.setTitle("Falla pagos");
            t2.setDescription("El sistema rechaza tarjetas válidas");
            t2.setStatus("EN PROCESO");
            t2.setRequester(user1);
            t2.setAssignee(user2);
            ticketRepository.save(t2);

            System.out.println("✅ Datos iniciales cargados");
        };
    }
}
