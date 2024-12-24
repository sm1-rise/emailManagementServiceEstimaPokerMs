package br.com.samuel.martins.EmailServiceManagement.infra.rabbitMQ.dto;

public record EmailBodyDto(String id,
                           String username,
                           String sendTo,
                           String subject,
                           String text    ) {
}

