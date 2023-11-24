package com.example.mscourse.api;

import com.example.mscourse.bl.ProgressBl;
import com.example.mscourse.dto.ProgressMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/progress")
public class ProgressApi {

    @Autowired
    private ProgressBl progressBl;

    @PostMapping
    public String sendProgressNotification(@RequestParam("routingKey") String routingKey,
                                           @RequestBody ProgressMessageDto message) {
        return progressBl.sendProgressNotification(routingKey, message);
    }
}
