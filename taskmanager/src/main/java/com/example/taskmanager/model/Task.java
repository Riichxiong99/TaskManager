package com.example.taskmanager.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;



@Entity
@Table(name = "tasks")

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt = LocalDateTime.now();
    }



}