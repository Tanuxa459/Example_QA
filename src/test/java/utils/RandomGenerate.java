package utils;
import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerate {


    Faker faker = new Faker(new Locale("en-GB"));

    public  String getFirstName() {

        return faker.name().firstName();
    }

    public String getLastName() {

        return faker.name().lastName();
    }

    public String getUserEmail() {

        return faker.internet().emailAddress();
    }

    public String getUserPhone() {
        return  faker.number().digits(10);

    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }
    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public String getRandomHobbies() {
        String[] hobbies = {"Sports", "Music", "Reading"};

        return getRandomItemFromArray(hobbies);
    }
    public String getRandomSubject() {
        String[] subjects = { "Biology",
                "Chemistry", "Civics", "Commerce", "Computer Science", "Economics", "English", "Hindi",
                "History", "Maths", "Physics", "Social Studies"};

        return getRandomItemFromArray(subjects);
    }

    public String getStreetAddress() {

        return new Faker().address().fullAddress();
    }

    public String getRandomState(){

        return  faker.options().option("NCR", "Uttar Pradesh", "Haryana");

    }
    public String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");

            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");

            case "Haryana":
                return faker.options().option("Karnal", "Panipat");

        }

        return state;
    }

    public String getRandomMonth(){

        return faker.options().option("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December");

    }
    public String getRandomYear(){

        return String.format("%s", faker.number().numberBetween(1960, 2024));

    }
    public String getRandomDay(){

        return String.format("%s", faker.number().numberBetween(1,28));

    }
    public String getRandomPicture(){

        return  faker.options().option("Test.jpg","Test2.png");

    }

}
