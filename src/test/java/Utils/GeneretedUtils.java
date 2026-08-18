package Utils;

import com.github.javafaker.Faker;
import java.security.SecureRandom;

public class GeneretedUtils {
    static Faker faker = new Faker();

        public static String getRandomString ( int leght){
            String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            StringBuilder result = new StringBuilder();
            SecureRandom rnd = new SecureRandom();
            for (int i = 0; i < leght; i++)
                result
                        .append
                                (LETTERS.charAt
                                        (rnd.nextInt
                                                (LETTERS.length())));


            return result.toString();
        }


    public static String SelectCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> state;
        };
    }

}
