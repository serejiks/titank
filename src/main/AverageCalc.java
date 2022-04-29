package main;

import java.util.ArrayList;

public class AverageCalc {
    public static double averageAgeOfSurvivingWomen (ArrayList<Person> personList) {
        return personList.stream().filter(x -> x.getSex().equals("female") && x.getSurvived() == 1)
                .mapToDouble(Person::getAge).average().getAsDouble();
    }

    public static double averageAgeOfDrownedMen (ArrayList<Person> personList) {
        return personList.stream().filter(x -> x.getSex().equals("male") && x.getSurvived() == 0)
                .mapToDouble(Person::getAge).average().getAsDouble();
    }
}
