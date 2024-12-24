package br.com.samuel.martins.EmailServiceManagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Email  {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;

    private String username;

    private String emailFrom;

    private String sendTo;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String text;

    private LocalDateTime emailSentAt;
}
