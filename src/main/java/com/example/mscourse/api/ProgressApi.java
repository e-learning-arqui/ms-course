package com.example.mscourse.api;

import com.example.mscourse.bl.ProgressBl;
import com.example.mscourse.dto.ProgressMessageDto;
import com.example.mscourse.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses/classes/progress")
public class ProgressApi {

    @Autowired
    private ProgressBl progressBl;

    @PostMapping()
    public ResponseDto<String> sendProgressNotification(@RequestParam("routingKey") String routingKey,
                                                @RequestBody ProgressMessageDto message) {
        System.out.println("Routing key: " + routingKey);
        System.out.println("Message: " + message.getUserKeyCloakId());
        System.out.println("Message: " + message.getClassId());
        ResponseDto<String> response = new ResponseDto<>();
        try {
            String result = progressBl.sendProgressNotification(routingKey, message);
            response.setCode("0000");
            response.setResponse(result);
            return response;
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }
    }
}
