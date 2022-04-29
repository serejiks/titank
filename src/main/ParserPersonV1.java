package main;

public class ParserPersonV1 implements IParserPerson {
    @Override
    public Person pars(String line) {
        String name = line.substring(line.indexOf(",\"") + 2, line.indexOf("\","));
        String[] row = line.replace(",\""+name+"\"", "").split(",");
        row[4] = row[4] == "" ? String.valueOf(0) : row[4];
        return new Person(name, Double.parseDouble(row[4]), Integer.parseInt(row[1]), row[3]);
    }
}
