package com.example.todolist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Tasks")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;
    private Boolean completed;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime uptadeAt;

    @PrePersist
    public void prePersist(){
        LocalDateTime current = LocalDateTime.now();
        this.createdAt = current;
        this.uptadeAt = current;
    }

    @PreUpdate
    public void preUpdate(){
        this.uptadeAt = LocalDateTime.now();
    }



}
