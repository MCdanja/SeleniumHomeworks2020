package project.functions;

import aquality.selenium.utils.JsonFile;

import java.util.Random;

public class CommonFunctions {

    private static JsonFile config = new JsonFile("config.json");

    public static String getConfigValue(String configKey) {
        return config.getValue("/" + configKey).toString();
    }

    public static String getRandomMail(int length) {
        return getRandomString(length).concat("@mail.ru");
    }

    public static String getRandomString(int length) {
        String lowerSymbols = "abcdefghijklmnopqrstuvwxyz";
        String upperSymbols = lowerSymbols.toUpperCase();
        String digits = "1234567890";
        String SaltChars = lowerSymbols + upperSymbols + digits;
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) {
            int index = (int) (rnd.nextFloat() * SaltChars.length());
            salt.append(SaltChars.charAt(index));
        }
        return salt.toString();
    }

    public static int getRandomPositiveNumber(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}
