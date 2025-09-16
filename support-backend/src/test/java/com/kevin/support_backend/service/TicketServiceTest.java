//package com.kevin.support_backend.service;
//
//import com.kevin.support_backend.model.Ticket;
//import com.kevin.support_backend.model.User;
//import com.kevin.support_backend.repository.TicketRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class TicketServiceTest {
//
//    @Mock
//    private TicketRepository ticketRepository;
//
//    private AutoCloseable closeable;
//
//    @InjectMocks
//    private TicketService ticketService;
//
//    @BeforeEach
//    void setUp() {
//        closeable = MockitoAnnotations.openMocks(this);
//    }
//    @AfterEach
//    void tearDown() throws Exception {
//        closeable.close();
//    }
//
//    @Test
//    void testCreateTicket() {
//        Ticket ticket = new Ticket();
//        ticket.setTitle("Error en login");
//
//        User user = new User();
//        user.setId(1L);
//        user.setUsername("kevin");
//
//        when(ticketRepository.save(ticket)).thenReturn(ticket);
//
//        Ticket result = ticketService.createTicket(ticket, user);
//
//        assertNotNull(result);
//        assertEquals("Error en login", result.getTitle());
//        verify(ticketRepository, times(1)).save(ticket);
//    }
//
//
//    @Test
//    void testGetTicketById() {
//        Ticket ticket = new Ticket();
//        ticket.setId(1L);
//        ticket.setTitle("Prueba");
//
//        when(ticketRepository.findById(1L)).thenReturn(Optional.of(ticket));
//
//        Optional<Ticket> result = ticketService.getTicketById(1L);
//
//        assertTrue(result.isPresent());
//        assertEquals("Prueba", result.get().getTitle());
//    }
//
//    @Test
//    void testGetAllTickets() {
//        Ticket t1 = new Ticket(); t1.setTitle("Uno");
//        Ticket t2 = new Ticket(); t2.setTitle("Dos");
//
//        when(ticketRepository.findAll()).thenReturn(Arrays.asList(t1, t2));
//
//        var result = ticketService.getAllTickets();
//
//        assertEquals(2, result.size());
//    }
//
//    @Test
//    void testDeleteTicket() {
//        ticketService.deleteTicket(1L);
//        verify(ticketRepository, times(1)).deleteById(1L);
//    }
//}
