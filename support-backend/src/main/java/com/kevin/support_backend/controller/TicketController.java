package com.kevin.support_backend.controller;

import com.kevin.support_backend.model.Ticket;
import com.kevin.support_backend.repository.TicketRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:5173")
public class TicketController {

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @PutMapping("/{id}")
    public Ticket update(@PathVariable Long id, @RequestBody Ticket ticket) {
        ticket.setId(id);
        return ticketRepository.save(ticket);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ticketRepository.deleteById(id);
    }
}
