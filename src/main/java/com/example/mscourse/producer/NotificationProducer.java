package com.example.mscourse.producer;

import com.example.mscourse.dto.ProgressMessageDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class NotificationProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    Logger log = Logger.getLogger(NotificationProducer.class.getName());

    public NotificationProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public String sendProgressNotification(String routingKey, ProgressMessageDto message) {
        log.info("Sending notification to queue");
        amqpTemplate.convertAndSend("topic-exchange", routingKey, message);
        return "Notification sent to queue with routing key: " + routingKey + " and message: " + message.toString();
    }
}
