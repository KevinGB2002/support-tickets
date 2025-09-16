package com.kevin.support_backend.service;

import com.kevin.support_backend.model.Ticket;
import com.kevin.support_backend.model.User;
import com.kevin.support_backend.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket createTicket(Ticket ticket, User requester) {
        ticket.setRequester(requester);   // en Ticket existe requester, no createdBy
        ticket.setCreatedAt(Instant.now());
        ticket.setStatus("ABIERTO");
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        Ticket ticket = getTicketById(id)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado con id: " + id));
        ticket.setTitle(ticketDetails.getTitle());
        ticket.setDescription(ticketDetails.getDescription());
        ticket.setStatus(ticketDetails.getStatus());
        ticket.setUpdatedAt(Instant.now());
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    public List<Ticket> getTicketsByStatus(String status) {
        return ticketRepository.findByStatus(status);
    }

    public List<Ticket> getTicketsByAssignee(User user) {
        return ticketRepository.findByAssignee(user);
    }
}