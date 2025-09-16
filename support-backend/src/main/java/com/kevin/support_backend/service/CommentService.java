package com.kevin.support_backend.service;

import com.kevin.support_backend.model.Comment;
import com.kevin.support_backend.model.Ticket;
import com.kevin.support_backend.model.User;
import com.kevin.support_backend.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getCommentsByTicket(Ticket ticket) {
        return commentRepository.findByTicket(ticket);
    }

    public Comment addComment(Ticket ticket, User user, String content) {
        Comment comment = new Comment();
        comment.setTicket(ticket);
        comment.setAuthor(user);
        comment.setContent(content);
        comment.setCreatedAt(Instant.now());
        return commentRepository.save(comment);
    }
}
