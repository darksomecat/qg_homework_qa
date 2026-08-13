package tests.testdata;

import Utils.GeneretedUtils;
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
    public  String userNumber = generatePhoneNumber(10);
    public  String subjectsInput = GeneretedUtils.getRandomSubjects();
    public  String hobbies = GeneretedUtils.getRandomHobbies();
    public  String state = selectedState();
    public  String city = SelectCity(state);
    public  String gender  = GeneretedUtils.getRandomGender();
    public  String invalidShortUserNumber = generatePhoneNumber(1);
    public  String phoneInputWithLetters = getRandomString(10);
    public  int birthDay = faker.number().numberBetween(1, 29);
    public  String birthMonth = GeneretedUtils.getRandomMonth();
    public  int birthYear = faker.number().numberBetween(1900, 2100);
    public  String fileName = "images.jpeg";

}
