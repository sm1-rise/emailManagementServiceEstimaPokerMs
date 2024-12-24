package br.com.samuel.martins.EmailServiceManagement.infra.rabbitMQ;

import br.com.samuel.martins.EmailServiceManagement.infra.rabbitMQ.dto.EmailBodyDto;
import br.com.samuel.martins.EmailServiceManagement.model.Email;
import br.com.samuel.martins.EmailServiceManagement.model.User;
import br.com.samuel.martins.EmailServiceManagement.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.rabbitmq.client.Channel;

@Component
public class QueueConsumer {

    private final EmailService emailService;

    public QueueConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload EmailBodyDto message) {
            System.out.println("Received message: " + message);
            var email = new Email();
            BeanUtils.copyProperties(message, email);
            emailService.sendEmail(email);
    }
}
