package tests.testdata;

import com.github.javafaker.Faker;
import static Utils.GeneretedUtils.*;

public class TestData {
    Faker faker = new Faker();

    public  String userName = faker.name().firstName();
    public  String fullName = faker.name().fullName();
    public  String specChars = faker.regexify("[!@#$%^&*()_+\\-=\\[\\]{};':\",./<>?]{10}");
    public  String userLastName = faker.name().lastName();
    public  String userEmail = faker.internet().emailAddress();
    public  String currentAddress = faker.address().fullAddress();
    public  String permanentAddress = faker.address().fullAddress();
    public  String invalidUserEmail = getRandomString(8);
    public  String userNumber = faker.phoneNumber().subscriberNumber(10);
    public  String subjectsInput = faker.options().option("Maths", "Physics", "Chemistry", "Biology", "English", "Computer Science",
            "Economics", "Arts", "History", "Civics");
    public  String hobbies = faker.options().option("Sports", "Reading", "Music");
    public  String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public  String city = SelectCity(state);
    public  String gender  = faker.options().option("Male", "Female", "Other");
    public  String invalidShortUserNumber = faker.phoneNumber().subscriberNumber(1);
    public  String phoneInputWithLetters = getRandomString(10);
    public  int birthDay = faker.number().numberBetween(1, 29);
    public  String birthMonth = faker.options().option("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
    public  int birthYear = faker.number().numberBetween(1900, 2100);
    public  String fileName = "images.jpeg";

}
