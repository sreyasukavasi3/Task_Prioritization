package com.taskPrioritization.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String taskName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Effort effort;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    private Integer deadline;
    
    public enum Priority {
        HIGH, LOW
    }

    public enum Effort {
        HIGH, LOW
    }

    public enum Status {
        NOT_STARTED, INPROGRESS, BLOCKED, COMPLETED
    }

}