package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String file = "D:\\Projects\\titank\\src\\Sergey Tarasov - train.csv";
        ArrayList<Person> personList = Parser.parser(new ParserPersonV1(), file);
        int result = AverageCalc.averageAgeOfSurvivingWomen(personList);
        int result2 = AverageCalc.averageAgeOfDrownedMen(personList);
        System.out.println("Средний возраст выживших женщин: " + result);
        System.out.println("Средний возраст утонувших мужчин: " + result2);
        HashMap<Integer, Integer> map = new HashMap<>();
        personList.forEach(x -> {map.compute(x.getName().length(),(k, v) -> v == null ? 1: ++v);});
        for (Integer key : map.keySet()) {
            System.out.println("Количество символов в имени = " + key + ", количество таких имен = " + map.get(key));
        }
    }
}
