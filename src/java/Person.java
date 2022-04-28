package java;

public class Person {
    private String name;
    private int age;
    private int survived;
    private String sex;

    public Person(String name, int age, int survived, String sex) {
        this.name = name;
        this.age = age;
        this.survived = survived;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSurvived() {
        return survived;
    }

    public String getSex() {
        return sex;
    }
}
