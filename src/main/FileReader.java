package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader implements IReader{

    private File file;

    public FileReader(File file) {
        this.file = file;
    }

    @Override
    public String readLine() {
        String line = "";
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            line = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
