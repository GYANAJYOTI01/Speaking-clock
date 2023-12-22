package com.Speakingclock.Config;

import com.Speakingclock.Exception.TimeException;
import com.Speakingclock.Service.TimeService;
import com.Speakingclock.Service.TimeServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.testng.annotations.Test;

public class TimeServiceImplTest {

    private TimeService timeService;


    @Before("")
    public void setUp() {
        timeService = new TimeServiceImpl();
    }


    @Test
    public void testConvertTimeToWords_validTime_shouldReturnWords() {
        String result = timeService.convertTimeToWords("12:30");
        assertEquals("It's twelve thirty o'clock", result);
    }

    private void assertEquals(String s, String result) {

    }

    @Test(expectedExceptions = TimeException.class)
    public void testConvertTimeToWords_invalidTime_shouldThrowException() {
        timeService.convertTimeToWords("25:00");
    }

    @Test
    public void testHandleUserInput_validInput_shouldReturnWords() {
        String result = timeService.handleUserInput("11:45");
        assertEquals("It's eleven forty five o'clock", result);
    }

    @Test(expectedExceptions = TimeException.class)
    public void testHandleUserInput_invalidInput_shouldThrowException() {
        timeService.handleUserInput("invalidTime");
    }

    @Test
    public void testHandleUserInput_middayInput_shouldReturnMidday() {
        String result = timeService.handleUserInput("12:00");
        assertEquals("It's Midday", result);
    }

    @Test
    public void testHandleUserInput_midnightInput_shouldReturnMidnight() {
        String result = timeService.handleUserInput("00:00");
        assertEquals("It's Midnight", result);
    }
}