package TravelAgency.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {

    // Define password strength criteria
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 50;
    private static final String UPPERCASE_REGEX = ".*[A-Z].*";
    private static final String LOWERCASE_REGEX = ".*[a-z].*";
    private static final String DIGIT_REGEX = ".*\\d.*";
    private static final String SPECIAL_CHAR_REGEX = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*";

    public static boolean isPasswordValid(String password) {
        return isLengthValid(password) &&
                containsUppercase(password) &&
                containsLowercase(password) &&
                containsDigit(password) &&
                containsSpecialChar(password);
    }

    private static boolean isLengthValid(String password) {
        int length = password.length();
        return length >= MIN_LENGTH && length <= MAX_LENGTH;
    }

    private static boolean containsUppercase(String password) {
        return matchesRegex(password, UPPERCASE_REGEX);
    }

    private static boolean containsLowercase(String password) {
        return matchesRegex(password, LOWERCASE_REGEX);
    }

    private static boolean containsDigit(String password) {
        return matchesRegex(password, DIGIT_REGEX);
    }

    private static boolean containsSpecialChar(String password) {
        return matchesRegex(password, SPECIAL_CHAR_REGEX);
    }

    private static boolean matchesRegex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
