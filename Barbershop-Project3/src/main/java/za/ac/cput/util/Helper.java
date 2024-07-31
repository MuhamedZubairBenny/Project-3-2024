package za.ac.cput.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty())
            return true;
        return false;
    }

    public static boolean isLessThanZero(int i){
        if(i==0)
            return true;
        return false;
    }

    public static boolean isLessZero(double d){
        if(d==0)
            return true;
        return false;
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean emailIsValid(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static boolean dateIsValid(LocalDate date) {
        return date != null && !date.isBefore(LocalDate.now());
    }

    public static boolean timeIsValid(LocalTime time) {
        return time != null;
    }
}
