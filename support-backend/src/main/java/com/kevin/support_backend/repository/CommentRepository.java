package com.kevin.support_backend.repository;

import com.kevin.support_backend.model.Comment;
import com.kevin.support_backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTicket(Ticket ticket);
}
