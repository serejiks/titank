package main;

import java.util.ArrayList;

public class AverageCalc {
    public static int averageAgeOfSurvivingWomen (ArrayList<Person> personList) {
        double result =  personList.stream().filter(x -> x.getSex().equals("female") && x.getSurvived() == 1)
                .mapToDouble(Person::getAge).average().getAsDouble();
        return (int)Math.round(result);
    }

    public static int averageAgeOfDrownedMen (ArrayList<Person> personList) {
        double result = personList.stream().filter(x -> x.getSex().equals("male") && x.getSurvived() == 0)
                .mapToDouble(Person::getAge).average().getAsDouble();
        return (int)Math.round(result);
    }
}
