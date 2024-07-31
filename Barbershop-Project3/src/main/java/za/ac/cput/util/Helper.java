package za.ac.cput.util;

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
}
