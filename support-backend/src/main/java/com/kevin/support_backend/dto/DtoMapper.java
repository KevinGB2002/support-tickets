package com.kevin.support_backend.dto;

import com.kevin.support_backend.model.Ticket;
import com.kevin.support_backend.model.User;

public class DtoMapper {

    public static UserDTO toUserDTO(User user) {
        if (user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static TicketDTO toTicketDTO(Ticket ticket) {
        if (ticket == null) return null;

        TicketDTO dto = new TicketDTO();
        dto.setId(ticket.getId());
        dto.setTitle(ticket.getTitle());
        dto.setDescription(ticket.getDescription());
        dto.setStatus(ticket.getStatus());
        dto.setRequester(toUserDTO(ticket.getRequester()));
        dto.setAssignee(toUserDTO(ticket.getAssignee()));
        return dto;
    }
}