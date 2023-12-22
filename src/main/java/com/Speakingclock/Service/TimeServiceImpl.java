package com.Speakingclock.Service;// TimeServiceImpl.java
import com.Speakingclock.Exception.TimeException;
import com.Speakingclock.Payload.TimePayload;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class TimeServiceImpl implements TimeService {

    @Override
    public String convertTimeToWords(String time) {
        try {
            LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
            int hours = localTime.getHour();
            int minutes = localTime.getMinute();

            if (isMidday(hours, minutes)) {
                return "It's Midday";
            } else if (isMidnight(hours, minutes)) {
                return "It's Midnight";
            } else {
                String hourInWords = convertToWords(hours);
                String minuteInWords = convertToWords(minutes);

                return "It's " + hourInWords + " " + (minutes != 0 ? minuteInWords + " " : "") + "o'clock";
            }
        } catch (Exception e) {
            throw new TimeException("Invalid time format");
        }
    }


        @Override
        public String handleUserInput(String userInput) {
            try {
                LocalTime localTime = LocalTime.parse(userInput, DateTimeFormatter.ofPattern("HH:mm"));
                int hours = localTime.getHour();
                int minutes = localTime.getMinute();

                if (isMidday(hours, minutes)) {
                    return "It's Midday";
                } else if (isMidnight(hours, minutes)) {
                    return "It's Midnight";
                } else {
                    String hourInWords = convertToWords(hours);
                    String minuteInWords = convertToWords(minutes);

                    return "It's " + hourInWords + " " + (minutes != 0 ? minuteInWords + " " : "") + "o'clock";
                }
            } catch (DateTimeParseException e) {

                throw new TimeException("Invalid time format. Please provide a valid time in HH:mm format.");
            } catch (Exception e) {
                // Handle other exceptions
                throw new TimeException("An error occurred while processing the time.");
            }
        }

    @Override
    public String handleUserInput(TimePayload timePayload) {
        return null;
    }


    private String convertToWords(int number) {
        if (number < 0 || number > 59) {
            throw new TimeException("Invalid minutes or hours");
        }

        if (number == 0) {
            return "zero";
        } else if (number <= 20) {
            return getNumberWord(number);
        } else {
            int tens = number / 10;
            int ones = number % 10;

            String tensWord = getTensWord(tens);
            String onesWord = getNumberWord(ones);

            return tensWord + (ones > 0 ? " " + onesWord : "");
        }
    }

    private String getNumberWord(int number) {
        switch (number) {
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            case 20: return "twenty";
            default: return "";
        }
    }

    private String getTensWord(int tens) {
        switch (tens) {
            case 2: return "twenty";
            case 3: return "thirty";
            case 4: return "forty";
            case 5: return "fifty";
            default: return "";
        }
    }

    private boolean isMidday(int hours, int minutes) {
        return hours == 12 && minutes == 0;
    }


    private boolean isMidnight(int hours, int minutes) {
        return hours == 0 && minutes == 0;
    }
}
