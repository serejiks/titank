package java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        String file = "src\\train.csv";
        String line = "";
        ArrayList<Person> personList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                personList.add(new Person(row[3], Integer.parseInt(row[5]), Integer.parseInt(row[1]), row[4]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OptionalDouble result = personList.stream().filter(x -> x.getSex().equals("female") && x.getSurvived() == 1)
                .mapToInt(Person::getAge).average();
        OptionalDouble result2 = personList.stream().filter(x -> x.getSex().equals("male") && x.getSurvived() == 0)
                .mapToInt(Person::getAge).average();

        HashMap<String, Integer> map = personList.stream().forEach(x -> map.put(x.));

        System.out.print(result);
    }
}
