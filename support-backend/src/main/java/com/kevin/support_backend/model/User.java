// src/main/java/com/kevin/support_backend/model/User.java
package com.kevin.support_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users") // 'user' es palabra reservada en algunas BD
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    private String role; // admin, agent, user (puedes usar Enum más adelante)

    @OneToMany(mappedBy = "requester")
    @JsonIgnore
    @JsonManagedReference
    private Set<Ticket> requestedTickets = new HashSet<>();

    @OneToMany(mappedBy = "assignee")
    @JsonManagedReference
    private Set<Ticket> assignedTickets = new HashSet<>();

    // ====== Getters y Setters ======
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Ticket> getRequestedTickets() {
        return requestedTickets;
    }

    public void setRequestedTickets(Set<Ticket> requestedTickets) {
        this.requestedTickets = requestedTickets;
    }

    public Set<Ticket> getAssignedTickets() {
        return assignedTickets;
    }

    public void setAssignedTickets(Set<Ticket> assignedTickets) {
        this.assignedTickets = assignedTickets;
    }
}