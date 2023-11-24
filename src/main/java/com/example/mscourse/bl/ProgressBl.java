package com.example.mscourse.bl;

import com.example.mscourse.dto.ProgressMessageDto;
import com.example.mscourse.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ProgressBl {
    @Autowired
    private NotificationProducer notificationProducer;


    Logger log = Logger.getLogger(ProgressBl.class.getName());
    public ProgressBl(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    public String sendProgressNotification(String routingKey, ProgressMessageDto message) {
        log.info("Sending notification to queue with " + routingKey);
        return notificationProducer.sendProgressNotification(routingKey, message);
    }
}
