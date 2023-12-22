package com.Speakingclock.Controller;


import com.Speakingclock.Payload.TimePayload;
import com.Speakingclock.Service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-input")
@Validated
public class UserInputController {

    @Autowired
    private TimeService timeService;

    @PostMapping("/handle-time")
    public String handleUserInput(@RequestBody TimePayload timePayload) {
        return timeService.convertTimeToWords(timePayload.getTime());
    }
}
