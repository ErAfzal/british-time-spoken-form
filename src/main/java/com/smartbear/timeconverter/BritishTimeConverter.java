package com.smartbear.timeconverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class BritishTimeConverter {

    private static final Map<Integer, String> MINUTE_WORDS = createMinuteWords();


    public  String toSpokenForm(String time) {

        validateTimeFormat(time);

        if (time.equals("00:00")) return "midnight";
        if (time.equals("12:00")) return "noon";

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);

        String spokenHour = HOUR_WORDS[hour % 12];
        String nextHour = HOUR_WORDS[(hour + 1) % 12];

        switch (min) {
            case 0:
                return spokenHour + " o'clock";
            case 15:
                return "quarter past " + spokenHour;
            case 30:
                return "half past " + spokenHour;
            case 45:
                return "quarter to " + nextHour;
            default:
                if (min < 30)
                    return  MINUTE_WORDS.get(min)+" past " + spokenHour;
                else if (min<35) return spokenHour+" "+ MINUTE_WORDS.get(min) ;
                else
                    return MINUTE_WORDS.get(60 - min) + " to " + nextHour;
        }
    }

    private static Map<Integer, String> createMinuteWords() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one minute");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(21, "twenty-one");
        map.put(22, "twenty-two");
        map.put(23, "twenty-three");
        map.put(24, "twenty-four");
        map.put(25, "twenty-five");
        map.put(26, "twenty-six");
        map.put(27, "twenty-seven");
        map.put(28, "twenty-eight");
        map.put(29, "twenty-nine");
        map.put(31, "thirty-one");
        map.put(32, "thirty-two");
        map.put(33, "thirty-three");
        map.put(34, "thirty-four");
        return map;
    }


    private  final String[] HOUR_WORDS = {
            "twelve", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven"
    };


    private  void validateTimeFormat(String time) {
        if (time == null ) {
            throw new IllegalArgumentException("Time must be in HH:mm format");

        }
        time=time.trim(); //cleaning

        if( !time.matches("\\d{1,2}:\\d{2}")){
            throw new IllegalArgumentException("Time must be in HH:mm format");

        }


        String[] parts = time.split(":");
        int hour, min;
        try {
            hour = Integer.parseInt(parts[0]);
            min = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Time contains invalid numeric values");
        }

        if (hour < 0 || hour > 23 || min < 0 || min > 59) {
            throw new IllegalArgumentException("Hour must be 0–23 and minute must be 0–59");
        }
    }

}
