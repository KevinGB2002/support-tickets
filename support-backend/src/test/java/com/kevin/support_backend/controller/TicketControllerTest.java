//package com.kevin.support_backend.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.kevin.support_backend.model.Ticket;
//import com.kevin.support_backend.model.User;
//import com.kevin.support_backend.service.TicketService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Collections;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@Import(TicketControllerTest.MockConfig.class) // Importamos la config con mocks
//class TicketControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper; // 👈 inyectamos el mapper
//
//    @Autowired
//    private TicketService ticketService; // el mock lo inyecta la config
//
//    static class MockConfig {
//        @Bean
//        public TicketService ticketService() {
//            return Mockito.mock(TicketService.class); //
//        }
//    }
//
//    @Test
//    void testGetAllTickets() throws Exception {
//        Ticket t = new Ticket();
//        t.setId(1L);
//        t.setTitle("Ticket de prueba");
//
//        when(ticketService.getAllTickets()).thenReturn(Collections.singletonList(t));
//
//        mockMvc.perform(get("/api/tickets"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].title").value("Ticket de prueba"));
//    }
//
//    @Test
//    void testCreateTicket() throws Exception {
//        Ticket ticket = new Ticket();
//        ticket.setId(1L);
//        ticket.setTitle("Error en login");
//        ticket.setDescription("El usuario no puede iniciar sesión");
//        ticket.setStatus("OPEN");
//
//        when(ticketService.createTicket(any(Ticket.class), any(User.class))).thenReturn(ticket);
//
//        mockMvc.perform(post("/api/tickets")
//                        .param("userId", "1") // 👈 forma más explícita
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(ticket)))
//                .andExpectAll(status().isOk())
//                .andExpectAll(jsonPath("$.id").value(1L))
//                .andExpectAll(jsonPath("$.title").value("Error en login"))
//                .andExpectAll(jsonPath("$.status").value("OPEN"));
//    }
//}
