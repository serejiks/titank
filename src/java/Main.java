package java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String file = "src\\train.csv";
        String line = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                if (row[5].equals("female")) {

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
