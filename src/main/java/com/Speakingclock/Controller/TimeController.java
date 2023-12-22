package com.Speakingclock.Controller;


import com.Speakingclock.Exception.TimeException;
import com.Speakingclock.Payload.TimePayload;
import com.Speakingclock.Service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time")
@Validated
public class TimeController {
    @Autowired
    private TimeService timeService;

    //http://localhost:8080/time/convert?time=00:00(It's Midnight) or 15:23(It's fifteen twenty three o'clock) or 12:00 (It's Midday)
    //or 100:05(Invalid time format)
    //  URL: http://localhost:8080/user/convert?time=11:25

    @GetMapping("/convert")
    public String convertTimeToWords(@RequestParam String time) {
        return timeService.convertTimeToWords(time);
    }

    @PostMapping("/handle-input")
    public String handleUserInput(@RequestBody TimePayload timePayload) {
        return timeService.handleUserInput(timePayload.getTime());
    }

    @ExceptionHandler(TimeException.class)
    public ResponseEntity<String> handleTimeException(TimeException ex) {
        // You can add additional handling logic if needed
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    }

