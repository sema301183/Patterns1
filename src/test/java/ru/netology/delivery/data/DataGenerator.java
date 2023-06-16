package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataGenerator {


    private DataGenerator() {
    }

    public static String generateDate (int shift){

        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        String[] cities = {"Салехард","Анадырь","Ханты-Мансийск","Нарьян-Мар", "Ярославль", "Челябинск","Ульяновск", "Тюмень","Тула","Томск", "Оренбург", "Омск", "Новосибирск", "Нижний Новгород",  "Москва", "Магадан", "Липецк", "Санкт-Петербург",
                "Курск", "Курган", "Кострома", "Киров", "Кемерово", "Калуга", "Калининград", "Иркутск", "Иваново", "Воронеж", "Вологда",
                "Волгоград", "Владимир", "Брянск", "Белгород", "Астрахань", "Благовещенск",
                "Архангельск", "Хабаровск", "Ставрополь", "Пермь", "Красноярск", "Краснодар", "Петропавловск-Камчатский", "Чита", "Барнаул",
                "Чебоксары", "Грозный", "Абакан", "Ижевск", "Казань", "Владикавказ", "Якутск", "Саранск",
                "Йошкар-Ола", "Сыктывкар", "Петрозаводск", "Нальчик", "Магас", "Махачкала","Улан-Удэ", "Уфа", "Горно-Алтайск","Майкоп"};
        int n = (int)Math.floor(Math.random() * cities.length);
        return  cities[n];

    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhoneNumber(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {

        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhoneNumber(locale));
        }

        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }
    }

}