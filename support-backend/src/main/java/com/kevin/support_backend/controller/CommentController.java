package com.kevin.support_backend.controller;

import com.kevin.support_backend.model.Comment;
import com.kevin.support_backend.model.Ticket;
import com.kevin.support_backend.model.User;
import com.kevin.support_backend.service.CommentService;
import com.kevin.support_backend.service.TicketService;
import com.kevin.support_backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "http://localhost:5173")

public class CommentController {

    private final CommentService commentService;
    private final TicketService ticketService;
    private final UserService userService;

    public CommentController(CommentService commentService, TicketService ticketService, UserService userService) {
        this.commentService = commentService;
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @GetMapping("/ticket/{ticketId}")
    public List<Comment> getCommentsByTicket(@PathVariable Long ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
        return commentService.getCommentsByTicket(ticket);
    }

    @PostMapping
    public Comment addComment(@RequestParam Long ticketId, @RequestParam Long userId, @RequestBody String message) {
        Ticket ticket = ticketService.getTicketById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return commentService.addComment(ticket, user, message);
    }
}
