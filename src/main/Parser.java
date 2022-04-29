package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    public static ArrayList<Person> parser (IParserPerson parser, String fileName) {
        String line = "";
        ArrayList<Person> personList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine();
            while((line = reader.readLine()) != null) {
                personList.add(parser.pars(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personList;
    }
}
