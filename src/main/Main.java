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
        String line = "";
        ArrayList<Person> personList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            while((line = reader.readLine()) != null) {
                String name = line.substring(line.indexOf(",\"") + 2, line.indexOf("\","));

                String[] row = line.replace(",\""+name+"\"", "").split(",");
                row[4] = row[4] == "" ? String.valueOf(0) : row[4];
                personList.add(new Person(name, Double.parseDouble(row[4]), Integer.parseInt(row[1]), row[3]));
                System.out.println(personList.get(personList.size() - 1));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        OptionalDouble result = personList.stream().filter(x -> x.getSex().equals("female") && x.getSurvived() == 1)
                .mapToDouble(Person::getAge).average();
        OptionalDouble result2 = personList.stream().filter(x -> x.getSex().equals("male") && x.getSurvived() == 0)
                .mapToDouble(Person::getAge).average();

        System.out.println(result.getAsDouble());
        System.out.println(result2.getAsDouble());

        HashMap<Integer, Integer> map = new HashMap<>();
        personList.forEach(x -> {map.compute(x.getName().length(),(k, v) -> v == null ? 1: ++v);});

        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
