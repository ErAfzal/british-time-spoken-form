package com.smartbear.timeconverter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BritishTimeConverterTest {

    static BritishTimeConverter btc;

    @BeforeAll
    static void setup(){
        btc=new BritishTimeConverter();

    }
    @Test
    void testMidnight() {
        assertEquals("midnight", btc.toSpokenForm("00:00"));
    }

    @Test
    void testNoon() {
        assertEquals("noon", btc.toSpokenForm("12:00"));
    }

    @Test
    void testOClock() {
        assertEquals("one o'clock", btc.toSpokenForm("1:00"));
        assertEquals("five o'clock", btc.toSpokenForm("05:00"));
    }

    @Test
    void testMinutesPast() {
        assertEquals("five past two", btc.toSpokenForm("02:05"));
        assertEquals("ten past three", btc.toSpokenForm("03:10"));
        assertEquals("quarter past four", btc.toSpokenForm("04:15"));
        assertEquals("twenty past five", btc.toSpokenForm("05:20"));
        assertEquals("twenty-five past six", btc.toSpokenForm("06:25"));
    }

    @Test
    void testMinutesTo() {
        assertEquals("twenty-five to eight", btc.toSpokenForm("07:35"));
        assertEquals("twenty to nine", btc.toSpokenForm("08:40"));
        assertEquals("quarter to ten", btc.toSpokenForm("09:45"));
        assertEquals("five to twelve", btc.toSpokenForm("11:55"));
    }

    @Test
    void testHalfPast() {
        assertEquals("half past seven", btc.toSpokenForm("07:30"));
    }

    @Test
    void testExactMinute() {
        assertEquals("six thirty-two", btc.toSpokenForm("06:32"));
    }

    @Test
    void testInvalidTimeFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                btc.toSpokenForm("99:99"));

    }

    @Test
    void testInvalidFormats() {
        assertThrows(IllegalArgumentException.class, () -> btc.toSpokenForm(null));
        assertThrows(IllegalArgumentException.class, () -> btc.toSpokenForm("abc"));
        assertThrows(IllegalArgumentException.class, () -> btc.toSpokenForm(" 12:60 "));
        assertThrows(IllegalArgumentException.class, () -> btc.toSpokenForm("24:00"));
        assertThrows(IllegalArgumentException.class, () -> btc.toSpokenForm("12:345"));
    }
}
