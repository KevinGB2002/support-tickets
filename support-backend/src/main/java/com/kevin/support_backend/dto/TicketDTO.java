package com.kevin.support_backend.dto;

public class TicketDTO {
    private Long id;
    private String title;
    private String description;
    private String status;
    private UserDTO requester;
    private UserDTO assignee;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public UserDTO getRequester() { return requester; }
    public void setRequester(UserDTO requester) { this.requester = requester; }

    public UserDTO getAssignee() { return assignee; }
    public void setAssignee(UserDTO assignee) { this.assignee = assignee; }
}