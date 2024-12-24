package br.com.samuel.martins.EmailServiceManagement.service;


import br.com.samuel.martins.EmailServiceManagement.model.Email;
import br.com.samuel.martins.EmailServiceManagement.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service

public class EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender mailSender;

    @Value(value = "${spring.email.username}")
    private String emailFrom;

    public EmailService(EmailRepository emailRepository, JavaMailSender mailSender) {
        this.emailRepository = emailRepository;
        this.mailSender = mailSender;
    }

    public Email sendEmail(Email email) {
        try{
            email.setEmailSentAt(LocalDateTime.now());
            email.setEmailFrom(emailFrom);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getSendTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            mailSender.send(message);

        } catch (MailException e) {
            e.printStackTrace();
        }
        email.setId(null);
        return emailRepository.save(email);
    }
}
