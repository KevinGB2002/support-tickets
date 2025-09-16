package com.kevin.support_backend.repository;

import com.kevin.support_backend.model.Ticket;
import com.kevin.support_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByStatus(String status);
    List<Ticket> findByAssignee(User assignee);
    //List<Ticket> findByPriority(String priority);
}
