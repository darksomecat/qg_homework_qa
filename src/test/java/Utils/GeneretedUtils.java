package Utils;

import com.github.javafaker.Faker;
import java.security.SecureRandom;
import static Utils.RandomUtils.*;

public class GeneretedUtils {
    static Faker faker = new Faker();

    public static String getRandomGender(){
        String[] genders ={"Male", "Female", "Other"};
        return getRandomItemFromStringArray(genders);
    }

    public static String getRandomMonth(){
        String[] genders ={"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return getRandomItemFromStringArray(genders);
    }

    public static String getRandomSubjects(){
        String[] genders ={"Maths", "Physics", "Chemistry", "Biology", "English", "Computer Science",
                "Economics", "Arts", "History", "Civics"};
        return getRandomItemFromStringArray(genders);
    }

    public static String getRandomHobbies(){
        String[] genders ={"Sports", "Reading", "Music"};
        return getRandomItemFromStringArray(genders);
    }

    public static String generatePhoneNumber(int length) {
        String template = "#".repeat(length);
        return faker.numerify(template);
    }

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

    public static String selectedState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String SelectCity(String selectedState) {
        return switch (selectedState) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> selectedState;
        };
    }

}
