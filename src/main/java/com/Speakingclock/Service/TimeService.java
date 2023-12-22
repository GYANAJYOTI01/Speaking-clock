package com.Speakingclock.Service;

import com.Speakingclock.Payload.TimePayload;
import org.springframework.stereotype.Service;

@Service
public interface TimeService {
    String convertTimeToWords(String time);
    String handleUserInput(String userInput);

        String handleUserInput(TimePayload timePayload);
    }


